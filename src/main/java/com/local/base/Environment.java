package com.local.base;

import com.atf.config.Settings;
import com.local.base.enums.TmeLc;
import com.local.helper.ToyotaHelper;
import lombok.Data;
import org.testng.Assert;

@Data
public class Environment {

    private static final String UAT = "test";
    private static final String DEV = "dev";

    private Environment(String urlEnvironment, String xTmeLc) {
        this(urlEnvironment, xTmeLc, null);
    }

    private Environment(String urlEnvironment, String xTmeLc, String apps) {
        String nmsc = System.getProperty("NMSC");
        String urlExtension = apps == null ? "" : apps;
        String urlPrefix = getUrlPrefixWithAuthentication(urlEnvironment);
        String urlSuffix = getUrlSuffix(urlEnvironment);
        urlEnvironment = urlPrefix + urlSuffix;
        if (ToyotaHelper.isNullOrBlank(nmsc)) {
            setUpEnvironmentProperties(urlEnvironment + urlExtension, xTmeLc);
        } else {
            String prefix = nmsc.substring(0, 5);
            String suffix = nmsc.substring(3).toUpperCase();
            String testEnvironment = Settings.getProperty(suffix, Settings.getProperty("test.environment.properties.file"));
            urlPrefix = getUrlPrefixWithAuthentication(urlEnvironment);
            urlSuffix = getUrlSuffix(testEnvironment);
            testEnvironment = urlPrefix + urlSuffix;
            setUpEnvironmentProperties(testEnvironment + urlExtension, prefix);
        }
    }

    private String getUrlSuffix(String urlEnvironment) {
        return urlEnvironment.split("https://")[1];
    }

    private String getUrlPrefixWithAuthentication(String urlEnvironment) {
        if (urlEnvironment.contains("dxp")){
            return urlEnvironment.substring(0,8)+ Settings.getProperty("BasicAuthenticationuserNameDxp")+":"+Settings.getProperty("BasicAuthenticationPasswordDxp")+"@";
        }
        return urlEnvironment.substring(0,8)+ Settings.getProperty("BasicAuthenticationuserName")+":"+Settings.getProperty("BasicAuthenticationPassword")+"@";
    }

    public static void createNewEnvironment(String url, String xTmeLc, String apps) {
        Assert.assertFalse(ToyotaHelper.isNullOrBlank(url));
        Assert.assertFalse(ToyotaHelper.isNullOrBlank(xTmeLc));
        new Environment(url, xTmeLc, apps);
    }

    public static void createNewEnvironment(String xTmeLc) {
        Assert.assertFalse(ToyotaHelper.isNullOrBlank(xTmeLc));
        new Environment(null, xTmeLc);
    }

    public static void createNewEnvironment(String url, String xTmeLc) {
        Assert.assertFalse(ToyotaHelper.isNullOrBlank(url));
        Assert.assertFalse(ToyotaHelper.isNullOrBlank(xTmeLc));
        new Environment(url, xTmeLc);
    }

    private void setUpEnvironmentProperties(String url, String xTmeLc) {
        if (!ToyotaHelper.isNullOrBlank(url)) {
            String env = (url.contains(UAT) ? UAT : DEV);
            env = (env.equals("test") ? "acc" : "dev"); // UAT is currently pointing to ACC environment
            Constants.ENVIRONMENT = env;
            System.setProperty("ENVIRONMENTURL", url);
            System.setProperty("AGGREGATOR_URL", Settings.getProperty(String.format("aggregator.%s.url", env)));
            System.setProperty("SSO_MS_URL", Settings.getProperty(String.format("sso.ms.%s.url", env)));
            System.setProperty("CP_SERVICES_URL", Settings.getProperty(String.format("cp.%s.services.url", env)));
            System.setProperty("ECALL_REMOTE_SERVICE_URL", Settings.getProperty("ecall.remote.service.url"));
        }
        System.setProperty("TMELC", TmeLc.valueOf(xTmeLc).getTmeLc());
        Constants.TMELC = TmeLc.valueOf(xTmeLc);
        System.setProperty("TMEORIGIN", Constants.TME_PORTAL_TOYOTA);
        if (System.getProperty("TMEBRAND") == null) {
            System.setProperty("TMEBRAND", Constants.TOYOTA);
        }
    }
}

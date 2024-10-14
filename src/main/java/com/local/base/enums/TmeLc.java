package com.local.base.enums;

public enum TmeLc {
    en_tz("en-tz"),
    en_eu("en-eu"),
    hy_am("hy-am"),
    de_at("de-at"),
    az_az("az-az"),
    hr_ba("hr-ba"),
    nl_be("nl-be"),
    fr_be("fr-be"),
    bg_bg("bg-bg"),
    en_cy("en-cy"),
    de_de("de-de"),
    da_dk("da-dk"),
    de_ch("de-ch"),
    fr_ch("fr-ch"),
    it_ch("it-ch"),
    cs_cz("cs-cz"),
    et_ee("et-ee"),
    ru_ee("ru-ee"),
    es_es("es-es"),
    fi_fi("fi-fi"),
    fr_fr("fr-fr"),
    en_gb("en-gb"),
    ka_ge("ka-ge"),
    el_gr("el-gr"),
    hr_hr("hr-hr"),
    hu_hu("hu-hu"),
    en_ie("en-ie"),
    is_is("is-is"),
    it_it("it-it"),
    ru_kg("ru-kg"),
    ru_kz("ru-kz"),
    lt_lt("lt-lt"),
    lv_lv("lv-lv"),
    ru_lv("ru-lv"),
    fr_lu("fr-lu"),
    sr_me("sr-me"),
    nl_nl("nl-nl"),
    no_no("no-no"),
    pl_pl("pl-pl"),
    pt_pt("pt-pt"),
    ro_ro("ro-ro"),
    sr_rs("sr-rs"),
    ru_ru("ru-ru"),
    sv_se("sv-se"),
    sl_si("sl-si"),
    sk_sk("sk-sk"),
    ru_tj("ru-tj"),
    ru_tm("ru-tm"),
    tr_tr("tr-tr"),
    uk_ua("uk-ua"),
    sq_xk("sq-xk"),
    he_il("he-il");

    private String xTmeLc;

    TmeLc(String xTmeLc) {
        this.xTmeLc = xTmeLc;
    }

    public String getTmeLc() {
        return xTmeLc;
    }
}

package com.labmedical.Enums;

public enum Perfil {
    PACIENTE, MEDICO, ADMIN;

    public static boolean isValid(String value) {
        try {
            Perfil.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}

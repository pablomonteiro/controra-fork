package br.com.casamagalhaes.controra.utils;

import java.util.List;
import java.util.Objects;

public class CollectionsUtil {

    public static boolean isNullOrEmpty(List<?> list) {
        return Objects.isNull(list) || list.isEmpty();
    }

}

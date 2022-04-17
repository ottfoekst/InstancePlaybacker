package com.ottfoekst.instanceplaybacker.model.repository;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SoundDataRepositorySingleton {
    private static final SoundDataRepository INSTANCE = new SoundDataMap();

    public static SoundDataRepository getInstance() {
        return INSTANCE;
    }
}

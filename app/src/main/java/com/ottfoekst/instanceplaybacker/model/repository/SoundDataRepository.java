package com.ottfoekst.instanceplaybacker.model.repository;

import com.ottfoekst.instanceplaybacker.model.data.SoundData;

public interface SoundDataRepository {
    SoundData getSoundData(String name);
}

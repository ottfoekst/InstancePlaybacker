package com.ottfoekst.instanceplaybacker.model.service.sound;

import com.ottfoekst.instanceplaybacker.model.entity.player.SoundPlayer;
import com.ottfoekst.instanceplaybacker.model.entity.player.SoundPlayerFactory;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RepeatSoundPlayer implements Soundable {
    private final String fileName;
    private Optional<SoundPlayer> player = Optional.empty();

    @Override
    public void start() {
        player = Optional.ofNullable(SoundPlayerFactory.createStarted(fileName));
    }

    @Override
    public void stop() {
        player.ifPresent(SoundPlayer::stop);
        player = Optional.empty();
    }

    @Override
    public void forceStop() {
        stop();
    }
}

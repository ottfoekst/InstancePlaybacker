package com.ottfoekst.instanceplaybacker.model.service.sound;

import com.ottfoekst.instanceplaybacker.model.entity.recorder.SoundRecorder;
import com.ottfoekst.instanceplaybacker.model.entity.recorder.SoundRecorderFactory;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RepeatSoundRecorder implements Soundable {
    private final String fileName;
    private Optional<SoundRecorder> recorder = Optional.empty();

    @Override
    public void start() {
        recorder = Optional.ofNullable(SoundRecorderFactory.createStarted(fileName));
    }

    @Override
    public void stop() {
        recorder.ifPresent(SoundRecorder::stop);
        recorder = Optional.empty();
    }

    @Override
    public void forceStop() {
        recorder.ifPresent(SoundRecorder::forceStop);
        recorder = Optional.empty();
    }
}

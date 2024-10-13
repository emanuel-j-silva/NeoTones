package com.neotones.domain.usecases.arrangement;

import com.neotones.domain.usecases.arrangement.dto.ArrangementDTO;
import com.neotones.domain.usecases.arrangement.dto.ToneDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArrangementRepository {
    void save(ArrangementDTO arrangement);
    Optional<ArrangementDTO> findByUuid(UUID uuid);
    Optional<ArrangementDTO> findByTone(ToneDTO tone);
    List<ArrangementDTO> findByMusicUuid(UUID uuid);
}

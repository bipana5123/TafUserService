package com.tekarch.TafUserService.Services.Interface;

import com.tekarch.TafUserService.models.Taf;
import java.util.List;

public interface TafServiceInterface {

    List<Taf> getAllTaf();
    Taf getTafById(Long tafID);

    Taf postTaf(Taf taf);
    Taf putUpdateTaf(Taf taf);
    void deleteTaf(Long tafId);
}
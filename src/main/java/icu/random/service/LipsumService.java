package icu.random.service;

import icu.random.dto.lipsum.LipsumDto;
import kong.unirest.HttpResponse;

public interface LipsumService {

  HttpResponse<LipsumDto> getBytes(Integer amount);

  HttpResponse<LipsumDto> getParagraphs(Integer amount);

  HttpResponse<LipsumDto> getWords(Integer amount);

  HttpResponse<LipsumDto> getLists(Integer amount);
}

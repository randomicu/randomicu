package icu.random.service;

import icu.random.dto.lipsum.LipsumDto;
import kong.unirest.HttpResponse;

public interface LipsumService {

  HttpResponse<LipsumDto> getBytes(Integer amount, boolean startWithLorem);

  HttpResponse<LipsumDto> getParagraphs(Integer amount, boolean startWithLorem);

  HttpResponse<LipsumDto> getWords(Integer amount, boolean startWithLorem);

  HttpResponse<LipsumDto> getLists(Integer amount, boolean startWithLorem);
}

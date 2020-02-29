package icu.random.client.lipsum;

import icu.random.dto.lipsum.LipsumDto;
import kong.unirest.HttpResponse;

public interface LipsumClient {

  HttpResponse<LipsumDto> getBytes(int amount, String startWithLorem);

  HttpResponse<LipsumDto> getParagraphs(int amount, String startWithLorem);

  HttpResponse<LipsumDto> getWords(int amount, String startWithLorem);

  HttpResponse<LipsumDto> getLists(int amount, String startWithLorem);
}

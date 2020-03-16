package icu.random.client.lipsum;

import icu.random.dto.lipsum.LipsumDto;
import kong.unirest.HttpResponse;

public interface LipsumClient {

  HttpResponse<LipsumDto> getBytes(int amount, boolean startWithLorem);

  HttpResponse<LipsumDto> getParagraphs(int amount, boolean startWithLorem);

  HttpResponse<LipsumDto> getWords(int amount, boolean startWithLorem);

  HttpResponse<LipsumDto> getLists(int amount, boolean startWithLorem);
}

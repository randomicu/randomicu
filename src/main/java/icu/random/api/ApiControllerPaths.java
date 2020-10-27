package icu.random.api;

public class ApiControllerPaths {
  public static final String API_ROOT_PATH = "/api";
  public static final String API_VERSION = "/v1";
  public static final String RANDOM_SENTENCE_GENERATOR_PATH = "/generators/random-sentence";
  public static final String RANDOM_SENTENCES_GENERATOR_PATH = "/generators/random-sentences";
  public static final String SENTENCE_LIMITS_PATH = "/generators/sentence-limits";
  public static final String LOREM_LIMITS_PATH = "/generators/lorem-limits";

  public static final String LOREM_AS_BYTES_PATH = "/external/generators/lorem-bytes";
  public static final String LOREM_AS_WORDS_PATH = "/external/generators/lorem-words";
  public static final String LOREM_AS_PARAGRAPHS_PATH = "/external/generators/lorem-paragraphs";
  public static final String LOREM_AS_LISTS_PATH = "/external/generators/lorem-lists";

  public static final String FAKEDATA_ADDRESS = "/fakedata/{language}/address";
  public static final String FAKEDATA_PERSON = "/fakedata/{language}/person";
}

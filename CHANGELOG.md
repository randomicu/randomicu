## Randomicu Changelog
## [0.7.0](https://github.com/pythoninja/randomicu/compare/0.6.1...0.7.0) (2020-11-01)


### Features

* **healthcheck:** add database status ([3ca131a](https://github.com/pythoninja/randomicu/commit/3ca131a7ade3ea485eb48b5c1df73653ca0ff0f8))
* **healthcheck:** add fakedata-backend status ([93644ce](https://github.com/pythoninja/randomicu/commit/93644cef9121f010b438b84d5f50d446277ce17f))
* **healthcheck:** add internal fakedata healthcheck ([6bbd597](https://github.com/pythoninja/randomicu/commit/6bbd5970034d221601610bf29a306c0b79b0af21))


### Other

* **deps:** bump spring-boot-starter-parent ([6f3af98](https://github.com/pythoninja/randomicu/commit/6f3af984808ed36a3a0bf80939e3dad4e351f6c6))


### Refactoring

* decode urls when logging ([1af28b4](https://github.com/pythoninja/randomicu/commit/1af28b4ad377238e566d19fb6afd45499d5c0288))

### [0.6.1](https://github.com/pythoninja/randomicu/compare/0.6.0...0.6.1) (2020-10-29)


### Features

* add database migrations before testing ([9d1e2b2](https://github.com/pythoninja/randomicu/commit/9d1e2b2ff51e4cf82fa245d56c87d2bfb61e6247))

## [0.6.0](https://github.com/pythoninja/randomicu/compare/0.5.0...0.6.0) (2020-10-27)


### Features

* **core:** add events processing and saving to database ([131373c](https://github.com/pythoninja/randomicu/commit/131373c0a4a85afb5d389443a5b7bf950b21ea78))
* add CORS headers to /api endpoints ([84c60ff](https://github.com/pythoninja/randomicu/commit/84c60ff7cd5984b5be340c661a01ea5254bfd339))


### Bug Fixes

* addressEndpoint should be variable not string ([0eeea3e](https://github.com/pythoninja/randomicu/commit/0eeea3e607833b61082b3ca3c0cd5174a959f8f7))


### Other

* **logs:** change log level to error for production ([a0fee32](https://github.com/pythoninja/randomicu/commit/a0fee3237f19671d16139c034f5a9a054854108b))


### CI / CD

* postgresql should be postgres on semaphore ([dcf3c5d](https://github.com/pythoninja/randomicu/commit/dcf3c5de8c704dced21a128b720abde355082c5f))


### Refactoring

* not found in fakedata mapped to 404 ([58c8076](https://github.com/pythoninja/randomicu/commit/58c8076ba86f5b9ac056c89b6a2fca33036fb9e3)), closes [#136](https://github.com/pythoninja/randomicu/issues/136)
* rename lipsum-limits to lorem-limits ([90395be](https://github.com/pythoninja/randomicu/commit/90395be9f0fcdab7a70b0e2595934b0456ae4a7b))

## [0.5.0](https://github.com/pythoninja/randomicu/compare/0.4.0...0.5.0) (2020-10-23)


### Features

* add logback-spring configuration ([7e7aead](https://github.com/pythoninja/randomicu/commit/7e7aead0eb32792eb35c5ff2d696bad0623157ac)), closes [#127](https://github.com/pythoninja/randomicu/issues/127)
* add logging points. ([1ec6826](https://github.com/pythoninja/randomicu/commit/1ec68262e62632e1b08f69cc1a2ea6f5eb3b5bea)), closes [#138](https://github.com/pythoninja/randomicu/issues/138)
* **fakedata:** extend DTOs for address and person endpoints ([3079f8f](https://github.com/pythoninja/randomicu/commit/3079f8f51dcc7946f6150f65714301953b9faef1)), closes [#132](https://github.com/pythoninja/randomicu/issues/132) [#134](https://github.com/pythoninja/randomicu/issues/134)


### Other

* **deps:** bump jib-maven-plugin from 2.5.2 to 2.6.0 ([4edf645](https://github.com/pythoninja/randomicu/commit/4edf64594972c0d15006e4e6f0ac27c21cc03a63))
* **deps:** bump unirest-java from 3.11.01 to 3.11.02 ([d447b05](https://github.com/pythoninja/randomicu/commit/d447b05599f9a75b57e78b0612e115577adbcaae))

## [0.4.0](https://github.com/pythoninja/randomicu/compare/0.4.0-stage.4...0.4.0) (2020-10-15)

## [0.4.0-stage.4](https://github.com/pythoninja/randomicu/compare/0.4.0-stage.3...0.4.0-stage.4) (2020-10-15)


### Bug Fixes

* fixed fakedata backend url ([15f0633](https://github.com/pythoninja/randomicu/commit/15f0633bf3ddb69d9d31b04ba7e49fdcd690569f))


### Other

* **deps:** bump unirest-java from 3.11.00 to 3.11.01 ([55f8ea3](https://github.com/pythoninja/randomicu/commit/55f8ea3d94a03113624dd76834c15837e598bfcf))
* **dev:** up node version in .nvmrc for development ([9ce55c5](https://github.com/pythoninja/randomicu/commit/9ce55c54a0180f9b106aa9c79fb2bcab4c0fd915))

## [0.4.0-stage.3](https://github.com/pythoninja/randomicu/compare/0.4.0-stage.2...0.4.0-stage.3) (2020-10-05)


### Bug Fixes

* return correct DTO for fakedata /address endpoint ([412e200](https://github.com/pythoninja/randomicu/commit/412e20074bda3476d00bf20aff1bef36d393154f))

## [0.4.0-stage.2](https://github.com/pythoninja/randomicu/compare/0.4.0-stage.1...0.4.0-stage.2) (2020-10-05)


### Bug Fixes

* **config:** remove port from fakedata backend ([82509ab](https://github.com/pythoninja/randomicu/commit/82509ab4632b8de531e4de9c87ca8a1941a800f1))

## [0.4.0-stage.1](https://github.com/pythoninja/randomicu/compare/0.3.4...0.4.0-stage.1) (2020-10-05)


### Features

* **fakedata:** add first client for fakedata backend ([89ec032](https://github.com/pythoninja/randomicu/commit/89ec032dd21f0491beece26ecbb6c6928fc86c5b))


### Bug Fixes

* **config:** correct fakedata backend url ([09fd8e9](https://github.com/pythoninja/randomicu/commit/09fd8e91fae7357c57c86cb0d50f266d5471e49b))


### Tests

* add fakedata related configuration to test properties ([91aa501](https://github.com/pythoninja/randomicu/commit/91aa5016d857abae4ba984fd18a30acf9779488c))


### Other

* **deps:** bump spring-boot-starter-parent ([71c6446](https://github.com/pythoninja/randomicu/commit/71c6446b1c564ad6ea7234d95060a6b20bd8170f))
* **deps:** bump unirest-java from 3.10.00 to 3.11.00 ([8731dd0](https://github.com/pythoninja/randomicu/commit/8731dd07e07908cc3d8d6b48380cf8ebeddbdd88))
* **deps:** bump unirest-java from 3.9.00 to 3.10.00 ([732b733](https://github.com/pythoninja/randomicu/commit/732b733e8b5cbb25a207c68535c710bbcc79ab16))
* **release:** 0.4.0-stage.0 ([86451a6](https://github.com/pythoninja/randomicu/commit/86451a60afc4807434860ae2b35c187efac231a5))

## [0.4.0-stage.0](https://github.com/pythoninja/randomicu/compare/0.3.4...0.4.0-stage.0) (2020-10-05)


### Features

* **fakedata:** add first client for fakedata backend ([89ec032](https://github.com/pythoninja/randomicu/commit/89ec032dd21f0491beece26ecbb6c6928fc86c5b))


### Tests

* add fakedata related configuration to test properties ([91aa501](https://github.com/pythoninja/randomicu/commit/91aa5016d857abae4ba984fd18a30acf9779488c))


### Other

* **deps:** bump spring-boot-starter-parent ([71c6446](https://github.com/pythoninja/randomicu/commit/71c6446b1c564ad6ea7234d95060a6b20bd8170f))
* **deps:** bump unirest-java from 3.10.00 to 3.11.00 ([8731dd0](https://github.com/pythoninja/randomicu/commit/8731dd07e07908cc3d8d6b48380cf8ebeddbdd88))
* **deps:** bump unirest-java from 3.9.00 to 3.10.00 ([732b733](https://github.com/pythoninja/randomicu/commit/732b733e8b5cbb25a207c68535c710bbcc79ab16))

### [0.3.4](https://github.com/pythoninja/randomicu/compare/0.3.3...0.3.4) (2020-08-14)


### Other

* **deps:** bump git-commit-id-plugin from 4.0.1 to 4.0.2 ([2524e69](https://github.com/pythoninja/randomicu/commit/2524e69000cc150595da1d0d920fc9004d11080d))
* **deps:** bump jib-maven-plugin from 2.4.0 to 2.5.1 ([9257c22](https://github.com/pythoninja/randomicu/commit/9257c2299291d4f363fe2f4dc63e58b9dfa1a24c))
* **deps:** bump jib-maven-plugin from 2.5.1 to 2.5.2 ([cd50192](https://github.com/pythoninja/randomicu/commit/cd5019242dfc38eaf5d7b23bc21550c164b5aeaa))
* **deps:** bump spring-boot-starter-parent ([93335d8](https://github.com/pythoninja/randomicu/commit/93335d8be0b2a67981b3bc2b9786868d9e6c2685))

### [0.3.3](https://github.com/pythoninja/randomicu/compare/0.3.2...0.3.3) (2020-08-04)


### Other

* **deps:** audit npm packages ([967eade](https://github.com/pythoninja/randomicu/commit/967eadec7f7a604480e4e46af3b2f98ee1e9ec71))
* **deps:** audit npm packages ([1c32b1e](https://github.com/pythoninja/randomicu/commit/1c32b1e1c69ecca9c92dbe34e716c25c3d88b126))
* **deps:** audit npm packages ([824fdef](https://github.com/pythoninja/randomicu/commit/824fdef817281c571a6899359db45d4b61bc7bf8))
* **deps:** bump commons-lang3 from 3.10 to 3.11 ([8d5a906](https://github.com/pythoninja/randomicu/commit/8d5a906e896591eded8d1c8aa558c2ec27eda7d5))
* **deps:** bump elliptic from 6.5.2 to 6.5.3 ([429f759](https://github.com/pythoninja/randomicu/commit/429f759647c632013fa3dcd48cd05ad174e01f03))
* **deps:** bump git-commit-id-plugin from 4.0.0 to 4.0.1 ([c5b0573](https://github.com/pythoninja/randomicu/commit/c5b057369591cf1fb025f12c3a9e3c83e106fb8b))
* **deps:** bump jib-maven-plugin from 2.2.0 to 2.4.0 ([5704587](https://github.com/pythoninja/randomicu/commit/57045879102a0795108af4f8d30197daaff03d5d))
* **deps:** bump lodash from 4.17.15 to 4.17.19 ([f5c9798](https://github.com/pythoninja/randomicu/commit/f5c9798cab8ab811b6da71b302f896d1e1c13580))
* **deps:** bump spring-boot-starter-parent ([39eb418](https://github.com/pythoninja/randomicu/commit/39eb418160aa325e513947a2de25977cd6b18392))
* **deps:** bump spring-boot-starter-parent ([4d30038](https://github.com/pythoninja/randomicu/commit/4d3003859751efb3f9c93c80939ead4ff21d6176))
* **deps:** bump spring-boot-starter-parent ([e6e1f08](https://github.com/pythoninja/randomicu/commit/e6e1f08d0891e345f538ecd28fc0fd91d170a1a9))
* **deps:** bump unirest-java from 3.7.02 to 3.7.04 ([3fd84e6](https://github.com/pythoninja/randomicu/commit/3fd84e667834360a7f5fc4392612a983f8781a71))
* **deps:** bump unirest-java from 3.7.04 to 3.8.06 ([a6a401e](https://github.com/pythoninja/randomicu/commit/a6a401e8845737b03d0b16d88fb3752f1eed27a1))
* **deps:** bump unirest-java from 3.8.06 to 3.9.00 ([3d6480d](https://github.com/pythoninja/randomicu/commit/3d6480df90d88227c853eba095f6c00731e206b4))
* **deps:** up purecss to 2.0.3 ([999ba14](https://github.com/pythoninja/randomicu/commit/999ba14d6f4ae0ec82669e1558a2eec0c6e816cc))

### [0.3.2](https://github.com/pythoninja/randomicu/compare/0.3.1...0.3.2) (2020-04-26)


### Features

* **lipsum:** add additionalBreak parameter ([adf34d2](https://github.com/pythoninja/randomicu/commit/adf34d2734f9ffb65dc6ea9d367da1d8b64c860c)), closes [#80](https://github.com/pythoninja/randomicu/issues/80)


### Other

* **deps:** bump commons-lang3 from 3.9 to 3.10 ([5949330](https://github.com/pythoninja/randomicu/commit/59493302ec0a0b71c3525c1e77b52b23a26c0fcf))
* **deps:** bump jib-maven-plugin from 2.1.0 to 2.2.0 ([0131bfc](https://github.com/pythoninja/randomicu/commit/0131bfce9a577f4b59e8bf912bfa3303ef2e47a4))
* **deps:** bump spring-boot-starter-parent ([084fb97](https://github.com/pythoninja/randomicu/commit/084fb977b03af537bb8b7ba9b99c03a21831ee9f))
* **deps:** bump unirest-java from 3.6.01 to 3.7.00 ([45a5d93](https://github.com/pythoninja/randomicu/commit/45a5d930e164ab5a8ccb720e5f3f4ef4eefc4282))
* **deps:** bump unirest-java from 3.7.00 to 3.7.01 ([c7d936d](https://github.com/pythoninja/randomicu/commit/c7d936d349f356641b8aefc57228571429d37de3))
* **deps:** bump unirest-java from 3.7.01 to 3.7.02 ([c60c568](https://github.com/pythoninja/randomicu/commit/c60c568b24fcba16e5018c481cedff23732dd25a))

### [0.3.1](https://github.com/pythoninja/randomicu/compare/0.3.0...0.3.1) (2020-03-18)


### Features

* **lipsum:** add socket timeout 2000ms ([5aaf9ed](https://github.com/pythoninja/randomicu/commit/5aaf9edf1522b2f41af66da554c5760bb453612e))
* **lipsum:** add startWithLorem parameter ([331fdbc](https://github.com/pythoninja/randomicu/commit/331fdbc39aa68fbbb2b64bc65cce9a9448de2101))


### Other

* **cleanup:** remove comment ([65bd245](https://github.com/pythoninja/randomicu/commit/65bd245c68d2f8a3cf84e1495632263fdbd0853a))
* **deps:** bump acorn from 5.7.3 to 5.7.4 ([04e61bf](https://github.com/pythoninja/randomicu/commit/04e61bfadcc19499da717fcd5841d7e57181dd8a))
* **deps:** bump unirest-java from 3.6.00 to 3.6.01 ([6b932d9](https://github.com/pythoninja/randomicu/commit/6b932d95726ce423ec5004d94ce892b3744f2fbe))
* **deps:** npm audit ([c319236](https://github.com/pythoninja/randomicu/commit/c3192360a25a28fb7c578b488bbd8963d2f91567))


### Refactoring

* **exceptions:** handle MethodArgumentTypeMismatch ([a9dee71](https://github.com/pythoninja/randomicu/commit/a9dee71deac016e1e5ad75f0b49bf50c44fc230e))
* **lipsum:** move remote url to variable ([9642d4a](https://github.com/pythoninja/randomicu/commit/9642d4a11c4d990ad24c2be3f060f702c522817a))


### Tests

* add lipsum variable to properties ([924e4df](https://github.com/pythoninja/randomicu/commit/924e4dfcb26357ca69329c81f396ff0181abe765))
* change assertable message ([1ba037f](https://github.com/pythoninja/randomicu/commit/1ba037f5d25df23ffb4195ee85d1162cd57510a2))

## [0.3.0](https://github.com/pythoninja/randomicu/compare/0.2.0...0.3.0) (2020-03-01)


### Features

* **lipsum:** add lipsum.com limits endpoint ([472f439](https://github.com/pythoninja/randomicu/commit/472f439dc973804c55f191726da54a74681f8e3f))


### Refactoring

* move limits endpoint to own controller ([8a0a6a3](https://github.com/pythoninja/randomicu/commit/8a0a6a31f6f0b5a9c84247d954eacef4646b835c))
* remove DAO layer ([e32c563](https://github.com/pythoninja/randomicu/commit/e32c563767e8b2f5e55cee8fedb881b2853307d2))

## [0.2.0](https://github.com/pythoninja/randomicu/compare/0.1.0...0.2.0) (2020-02-29)


### Features

* **lipsum:** add lipsum.com client ([1c3cbb0](https://github.com/pythoninja/randomicu/commit/1c3cbb0ed9f34409566790c6b9548fde7deb1fe2))


### Other

* **cleanup:** remove mvnw ([5207a77](https://github.com/pythoninja/randomicu/commit/5207a775de89ec1ab529298fce64dfcac54c0b1f))
* **deps:** add unirest-java 3.6.00 ([d6fa019](https://github.com/pythoninja/randomicu/commit/d6fa01994be69eda4898a966d09b64ccf74adf14))
* **deps:** bump jib-maven-plugin from 2.0.0 to 2.1.0 ([f5c581d](https://github.com/pythoninja/randomicu/commit/f5c581d86c435e0ad36c1721d812cf9089085bcc))
* **deps:** bump spring-boot-starter-parent ([09d489e](https://github.com/pythoninja/randomicu/commit/09d489e40e43267bf1b31de3d6d087a29597b052))
* **deps:** update node to 12.16.1 ([663f38b](https://github.com/pythoninja/randomicu/commit/663f38b3ce4cc5dfef02030882a11b3fff1a7f49))

## [0.1.0](https://github.com/pythoninja/randomicu/compare/0.0.6...0.1.0) (2020-01-30)


### Features

* **api:** add API version ([a4e386b](https://github.com/pythoninja/randomicu/commit/a4e386b122501830acf3e3fae1e97ef8bf130f2a)), closes [#48](https://github.com/pythoninja/randomicu/issues/48)
* **api:** add new limits endpoint ([b3ec98d](https://github.com/pythoninja/randomicu/commit/b3ec98d403cc1bcff4a2e8718b8556e199aae41e))


### Other

* **changelog:** refactor titled as Refactoring ([71e4773](https://github.com/pythoninja/randomicu/commit/71e4773d5bb2f957b06b5b2c6f90d993f2306ebe))


### Tests

* add tests to /limits endpoint ([324d47b](https://github.com/pythoninja/randomicu/commit/324d47b1796e5c85a74f025ba0b760960b837355))
* less magic numbers, more configurable vars ([33d503a](https://github.com/pythoninja/randomicu/commit/33d503ad8250ad447a8274af4bee8e44a77ae179))
* RANDOM_SENTENCES_URL is final now ([9a6efc2](https://github.com/pythoninja/randomicu/commit/9a6efc2c2cb2e00cbd482c28698ba8e3b15d76f9))
* reduce console output to INFO level ([ab8bfcd](https://github.com/pythoninja/randomicu/commit/ab8bfcd969a61910ea1b84ca2271b68ac76d8cb7))


### Refactoring

* remove unused HashMap import ([7215689](https://github.com/pythoninja/randomicu/commit/721568976f7c698c629d412d64d8f928c34d7121))

### [0.0.6](https://github.com/pythoninja/randomicu/compare/0.0.5...0.0.6) (2020-01-30)


### Features

* up max sentence length to 70k ([a11b8c2](https://github.com/pythoninja/randomicu/commit/a11b8c2715850a2deb7f077c3a38d6a6b1588197)), closes [#51](https://github.com/pythoninja/randomicu/issues/51)


### Tests

* fix max length in tests ([d06761a](https://github.com/pythoninja/randomicu/commit/d06761afe0e9a668c451fb762880b2be4bc42a11))

### [0.0.5](https://github.com/pythoninja/randomicu/compare/0.0.4...0.0.5) (2020-01-29)


### Bug Fixes

* header 2 for changelog ([33b3113](https://github.com/pythoninja/randomicu/commit/33b3113925ed273217cb89941762c4b467234036))
* restore style.css ([e8fcd66](https://github.com/pythoninja/randomicu/commit/e8fcd66814e5f10cb01a29fa535f97af0b7711b2))


### CI / CD

* restore node_modules right way ([c65f1e1](https://github.com/pythoninja/randomicu/commit/c65f1e1901a82a5e829e29f8f978d3a86ca234c4))
* restore node_modules right way ([74fb19f](https://github.com/pythoninja/randomicu/commit/74fb19fb35d9228b1a8befac49dbd796afc56514))


### Other

* **deps:** add conventional changelog ([93aa266](https://github.com/pythoninja/randomicu/commit/93aa26660a35335af51a937c42484372a21508ff))
* **deps:** bump jib-maven-plugin from 1.8.0 to 2.0.0 ([#54](https://github.com/pythoninja/randomicu/issues/54)) ([294006b](https://github.com/pythoninja/randomicu/commit/294006b1a61c9543cbee446bb0f919ad5122c05e))
* **deps:** bump spring-boot-starter-parent ([#52](https://github.com/pythoninja/randomicu/issues/52)) ([2877577](https://github.com/pythoninja/randomicu/commit/28775774643289dbe998cd1a6dc2ac89ecaaf542))
* **deps:** bump spring-boot-starter-parent ([#53](https://github.com/pythoninja/randomicu/issues/53)) ([94df86e](https://github.com/pythoninja/randomicu/commit/94df86e155ac07fdb64bd5865a356f69a0154b7a))

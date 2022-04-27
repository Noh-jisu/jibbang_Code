# jibbang_Code

공부한 자료 및 참고할 코드들을 올려두는 공간(내가 볼 코드)

1. API란 프로그램에서 운영체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있도록 만든 인터페이스

2. HTTP(Hyper Text Transfer Protocol)란 하이퍼텍스트 문서 리소스를 통신하는데 쓰이는 통신규약

3. REST란 HTTP URI를 통해 자원을 명시하고, HTTP Method(GET, POST, PUT, DELETE)를 통해 해당 자원에 대한 CRUD를 적용하는 것이다.

4. 객체와 클래스의 차이점
 - 클래스는 객체를 생성하기 위한 설계도 또는 틀
 - 객체는 설계도 또는 틀로 찍어낸 실체

5. java 기본형과 wrapper클래스의 차이점
 - 기본형은 변수에 값을 그대로 저장한다. ex) int a = 3; 은 a에 3이라는 값이 있는것
 - wrapper클래스는 객체의 레퍼런스에 저장한다. ex) Integer a = 3은 a의 주소값에 3이 저장된것

6. equals VS. == 연산자 차이점
 - equals : 문자열 자체를 비교
 - == 연산자 : 객체의 주소값을 비교

7. Retrofit
 - Retrofit은 OkHttp의 상위 구현체로 enqueue와 excute를 사용하여 동기, 비동기 처리를 지원한다
 - Retrofit의 장점은 속도, 편의성, 가독성이 있다. 가장 비교하기 좋은 Okhttp는 사용시 대개 Asynctask를 통해 비동기로 실행하게 되는데 Asynctask가 성능상 느리다는 이슈가 있었다. Retrofit에서는 Asynctask를 사용하지 않고 자체적인 비동기 실행과 스레드 관리를 통해 속도를 훨씬 빠르게 끌어올렸다. 약 3~10배 차이가 난다고 한다.

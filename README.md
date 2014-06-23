bloginit
========

Proyecto de Referencia (Curso de Java)

Enlaces
-------

- Mocks Aren't Stubs
http://martinfowler.com/articles/mocksArentStubs.html

Maven
-----

Para configurar el proxy, agregar lo siguiente al archivo $HOME_USER/settings.xml

<settings>
  <proxies>
   <proxy>
      <active>true</active>
      <protocol>http</protocol>
      <host>XXXXXXX</host>
      <port>8080</port>
    </proxy>
  </proxies>
</settings>


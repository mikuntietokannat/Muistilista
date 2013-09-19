public class Muistio implements Serializable {
    private Long muistioid;     //pkey
    private Kategoria kategoria;     //fkey
    private Long userid;        //fkey
    private int tarkeys;
    private String nimi;
    private String kuvaus;
public class Kayttaja implements Serializable {
    private Long userid;
    private String tunnus;
    private String salasana;
public class Kategoria implements Serializable {
    private Long kategorid; //pkey
    private Long userid; //fkey
    private List<Muistio> muistiot;
    private String nimi;



CREATE TABLE Muistio (
    muistioid NUMBER AUTO_INCREMENT,
    kategoria NUMBER,
    userid NUMBER,
    tarkeys NUMBER,
    nimi VARCHAR,
    kuvaus VARCHAR
    PRIMARY KEY (muistioid),
    FOREIGN KEY (kategoria) REFERENCES Kategoria(kategorid),
    FOREIGN KEY (userid) REFERENCES Kayttaja(userid)
);

CREATE TABLE Kayttaja (
    userid NUMBER AUTO_INCREMENT,
    tunnus VARCHAR,
    salasana VARCHAR,
    PRIMARY KEY (userid)
);

CREATE TABLE Kategoria (
    kategorid NUMBER AUTO_INCREMENT,
    userid NUMBER,
    nimi VARCHAR,
    PRIMARY KEY (userid),
);

CREATE TABLE Muistio_Kategoria (
    kategorid NUMBER,
    muistioid NUMBER,
    PRIMARY KEY (kategorid, muistioid)
);




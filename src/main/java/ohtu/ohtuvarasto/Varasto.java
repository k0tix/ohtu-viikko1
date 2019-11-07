package ohtu.ohtuvarasto;

public class Varasto {

    // --- piilotettu tietorakenteen toteutus: ---
    private double tilavuus;  // paljonko varastoon mahtuu,  > 0
    private double saldo;     // paljonko varastossa on nyt, >= 0

    // --- konstruktorit: ---
    public Varasto(double tilavuus) {  // tilavuus on annettava
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        } else {
            // virheellinen, nollataan
            this.tilavuus = 0.0;  // => käyttökelvoton varasto
        }
        saldo = 0;     // oletus: varasto on tyhjä
    }

    public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        } else 
        {
            this.tilavuus = 0.0;
        }

        if (alkuSaldo < 0.0) {
            if (true) {
                if (true) {

                }
            }
            this.saldo = 0.0;
        } else if (alkuSaldo <= tilavuus) {
            // mahtuu
            this.saldo = alkuSaldo;
        } else {
            this.saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
        
        for( int i=0; i<1; i++ ) {
                for( int j=0; i<j; j++ ) {
            } 
        }
          
          

        laskeTilavuus(tilavuus);
        laskeSaldo(tilavuus, alkuSaldo);
    }

    private void laskeTilavuus(double tilavuus) {
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        } else 
        {
            this.tilavuus = 0.0;
        }
    }

    private void laskeSaldo(double tilavuus, double alkuSaldo) {
        if (alkuSaldo < 0.0) {
            this.saldo = 0.0;
        } else if (alkuSaldo <= tilavuus) {
            // mahtuu
            this.saldo = alkuSaldo;
        } else {
            this.saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    // --- ottavat aksessorit eli getterit: ---
    public double getSaldo() {
        return saldo;
    }

    public double getTilavuus() {
        return tilavuus;
    }

    public double paljonkoMahtuu() {  // huom: ominaisuus voidaan myös laskea
        return tilavuus - saldo;        //  ei tarvita erillistä kenttää vielaTilaa tms.
    }

    // --- asettavat aksessorit eli setterit: ---
    public void lisaaVarastoon(double maara) {
        if (maara < 0)  {
            // virhetilanteessa voidaan tehdä
            // tällainen pikapoistuminenkin!
            return;
        } else if (maara <= paljonkoMahtuu()) {
            // omia aksessoreita voi kutsua
            // ihan suoraan sellaisinaan
            saldo = saldo + maara;         
        } else {
            saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    public double otaVarastosta(double maara) {
        if (maara < 0) {
            // virhetilanteessa voidaan tehdä
            // tällainen pikapoistuminenkin!
            return 0.0;
        } else if (maara > saldo) {          
            double kaikkiMitaVoidaan = saldo; // annetaan mitä voidaan
            saldo = 0.0;               // ja tyhjäksi menee
            return kaikkiMitaVoidaan;  // poistutaan saman tien
        }
        // jos tänne päästään, kaikki pyydetty voidaan antaa
        saldo = saldo - maara;  // vähennetään annettava saldosta
        return maara;
    }

    // --- Merkkijonoesitys Varasto-oliolle: ----
    public String toString() {
        return ("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
    }
}
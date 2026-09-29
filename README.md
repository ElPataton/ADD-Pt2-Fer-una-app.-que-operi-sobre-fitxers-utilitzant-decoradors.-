# Xifrat i desxifrat amb inversió de linia
Llegeix el contingut d'un fitxer que després inverteix i xifra amb el offset que indiquem de cesar, despŕes el desxifra i desinverteix en un nou fitxer.

## main (Encriptar)
### Creem la variable dels fitxers que ens permetrá accedir a ells, per escriure i llegir, en aquest cas nómes accedim al de data i xifrat ja que no es necessari el de desxifratje
    File f = new File("src/main/resources/data.txt");
    File xf = new File("src/main/resources/xifrat.txt");

### Creem el Scanner amb el que preguntarem quin es el offset de Cesar que volem utilitzar per xifrar el arxiu, sent el predefinit de 3. A més s'afegeix un control de error per si el usuari no escriu un numero.
    Scanner scanner = new Scanner(System.in);
        System.out.println("Amb quin Offset de Cesar vols cifrar? (Default: 3)");
        String input = scanner.nextLine();
        int cesaroff = 0;
        //Offset de cesar per defecte es 3
        if (input.isEmpty()) {
            cesaroff = 3;
        } else {
            try {
                cesaroff = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error, introdueix un numero");
                return;
            }
            System.out.println("Cesar offset escollit: " + cesaroff);
        }

###        
        try (
                BufferedReader br = new BufferedReader(new FileReader(f)); BufferedWriter bw = new BufferedWriter(new FileWriter(xf))) {



package almoxarifado;

import java.util.ArrayList;

public class AlmoxarifadoFacade {
    private ArrayList<Material> estoque;

    public AlmoxarifadoFacade() {
        this.estoque = new ArrayList<>();
    }

    public ArrayList<Material> getEstoque(){
        return this.estoque;
    }

    public void setEstoque(ArrayList<Material> estoque){
        this.estoque = estoque;
    }

    public boolean cadastrarMaterial(String nomeDoMaterial, double valorDoMaterial) {
        Material materialNovo = new Material(nomeDoMaterial, valorDoMaterial);

        if(estoque.contains(materialNovo)){
            return false;
        }
        estoque.add(materialNovo);
        return true;
    }

    public String mostrarEstoque() {
        StringBuilder estoqueToString = new StringBuilder();

        for (Material material : estoque) {
            estoqueToString.append(material.toString()).append("\n");
        }

        return estoqueToString.toString();
    }

    public boolean comprarMaterial(String nomeDoMaterial, double valorDoMaterial) {
        if(cadastrarMaterial(nomeDoMaterial, valorDoMaterial)){
            return true;
        } 
        return false;
    }
    
}

package beans;

public class Categoria {
    private int id;
    private String nomecategoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomecategoria() {
        return nomecategoria;
    }

    public void setNomecategoria(String nomecategoria) {
        this.nomecategoria = nomecategoria;
    }
    
    public String toString(){
        return this.nomecategoria;
    }
}

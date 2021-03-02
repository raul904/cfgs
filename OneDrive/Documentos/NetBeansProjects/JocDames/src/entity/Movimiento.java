package entity;
// Generated 07-feb-2021 19:49:36 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * Movimiento generated by hbm2java
 */
@Entity
@Table(name="movimiento")
public class Movimiento  implements java.io.Serializable {
    @Id
    @GeneratedValue
    @Column(name="idMovimiento")
     private Integer idMovimiento;
    @Column(name="idPartida")
     private Partida partida;
    @Column(name="columnaOri")
     private int columnaOri;
    @Column(name="columnaDesti")
     private int columnaDesti;
    @Column(name="filaOri")
     private int filaOri;
    @Column(name="filaDesti")
     private int filaDesti;

    public Movimiento() {
    }

    public Movimiento(Partida partida, int columnaOri, int columnaDesti, int filaOri, int filaDesti) {
       this.partida = partida;
       this.columnaOri = columnaOri;
       this.columnaDesti = columnaDesti;
       this.filaOri = filaOri;
       this.filaDesti = filaDesti;
    }
   
    public Integer getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    public Partida getPartida() {
        return this.partida;
    }
    
    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    public int getColumnaOri() {
        return this.columnaOri;
    }
    
    public void setColumnaOri(int columnaOri) {
        this.columnaOri = columnaOri;
    }
    public int getColumnaDesti() {
        return this.columnaDesti;
    }
    
    public void setColumnaDesti(int columnaDesti) {
        this.columnaDesti = columnaDesti;
    }
    public int getFilaOri() {
        return this.filaOri;
    }
    
    public void setFilaOri(int filaOri) {
        this.filaOri = filaOri;
    }
    public int getFilaDesti() {
        return this.filaDesti;
    }
    
    public void setFilaDesti(int filaDesti) {
        this.filaDesti = filaDesti;
    }




}


package com.au.pojo;
// Generated 26/03/2014 01:12:55 by Hibernate Tools 3.6.0



/**
 * ItempedidoId generated by hbm2java
 */
public class ItempedidoId  implements java.io.Serializable {


     private int idPedido;
     private int idProd;

    public ItempedidoId() {
    }

    public ItempedidoId(int idPedido, int idProd) {
       this.idPedido = idPedido;
       this.idProd = idProd;
    }
   
    public int getIdPedido() {
        return this.idPedido;
    }
    
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public int getIdProd() {
        return this.idProd;
    }
    
    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ItempedidoId) ) return false;
		 ItempedidoId castOther = ( ItempedidoId ) other; 
         
		 return (this.getIdPedido()==castOther.getIdPedido())
 && (this.getIdProd()==castOther.getIdProd());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdPedido();
         result = 37 * result + this.getIdProd();
         return result;
   }   


}



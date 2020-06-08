package model.produ;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModelProd extends AbstractTableModel {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ArrayList<Produto> listaProdutos = new ArrayList<>();  
    private String[] colunas = {"ID","NOME MARCA","QUANTIDADE","PRECO"};  
      
      
    public TableModelProd() {  
        this.listaProdutos = new ArrayList<>();  
          
    }  
  
    public void addProduto(Produto pProdutos){  
        this.listaProdutos.add(pProdutos);  
        this.fireTableDataChanged();  
    }  
      
    public void delProduto(int rowIndex){  
        this.listaProdutos.remove(rowIndex);  
    }  
          
      
    public void getPessoa(int rowIndex){  
        this.listaProdutos.get(rowIndex);  
    }  
      
      
    @Override  
    public int getColumnCount() {  
      
        return colunas.length;  
    }  
  
    @Override  
    public int getRowCount() {  
        return this.listaProdutos.size();  
    }  
  
    @Override  
    public Object getValueAt(int rowIndex, int columnIndex) {  
        switch (columnIndex) {  
        case 0:  
          return this.listaProdutos.get(rowIndex).getId();  
        
        case 1:  
         return this.listaProdutos.get(rowIndex).getNomeM();
         
        case 2:  
            return this.listaProdutos.get(rowIndex).getNomeG();
            
        case 3:  
            return this.listaProdutos.get(rowIndex).getLab();
            
        case 4:  
            return this.listaProdutos.get(rowIndex).getQtn();
            
        case 5:  
            return this.listaProdutos.get(rowIndex).getPreco();
          
        default:  
            return this.listaProdutos;    
        }  
          
    }  
      
    @Override  
    public String getColumnName(int column) {  
        return colunas[column];  
    }  
      
      
      
    public void addRow(Produto Produtos){  
        this.listaProdutos.add(Produtos);  
        this.fireTableDataChanged();  
          
    }  
      
      
    public void removeRow(int linha){  
          
        if(linha==-1){  
              
        }else{        
        this.listaProdutos.remove(linha);  
        this.fireTableRowsDeleted(linha, linha);  
        }  
    }  
  
}  
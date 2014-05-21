package renderer;

import entities.Libros;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {

    List<Libros> lista1;

    public void setDataList(List<Libros> list) {
        this.lista1 = list;
    }

    @Override
    public int getRowCount() {
        return lista1.size();
    }

    @Override
    public int getColumnCount() {
        return 7; //numero de columnas segun las que nos interesen
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libros libro = lista1.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return libro.getTitulo();
            case 1:
                return libro.getAutores();
            case 2:
                return libro.getPvpsiniva();
            case 3:
                if (libro.getIdEditorial() == null) {
                    return "";
                } else {
                    return libro.getIdEditorial().getNombre();
                }
            case 4:
                return libro.getFechaEdicion();
            case 5:
                return libro.getStockactual();
            case 6:
                return libro.getStockactual();
            default:
                return null;
        } //Retorna el objeto/valor en una casilla de la tabla
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Título";
            case 1:
                return "Autor";
            case 2:
                return "Precio sin IVA";
            case 3:
                return "Editorial";
            case 4:
                return "Año Edición";
            case 5:
                return "Agotandose";
            case 6:
                return "StockActual";
            default:
                return null;
        }
    }

}

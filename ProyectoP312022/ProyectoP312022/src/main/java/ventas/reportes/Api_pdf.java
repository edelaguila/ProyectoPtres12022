package ventas.reportes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pablo
 */
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Api_pdf {

Document document = new Document();
      

        
  public void creacion(String datos[][], String fecha, String correo, String cliente, String tipo){
 try{
            PdfWriter.getInstance(document, new FileOutputStream("formu_PDF.pdf"));
            
          Image header = Image.getInstance("C:\\Users\\Pablo\\Desktop\\descargas\\Material\\Captura.jpg");
           Image enca = Image.getInstance("C:\\Users\\Pablo\\Desktop\\omar\\ProyectoP312022\\ProyectoP312022\\Material\\factura.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment (Chunk.CCITTG3_1D);
            if(tipo.equals("factura")){
             enca = Image.getInstance("C:\\Users\\Pablo\\Desktop\\omar\\ProyectoP312022\\ProyectoP312022\\Material\\factura.jpg");
            }else if(tipo.equals("cotizacion")){
             enca = Image.getInstance("C:\\Users\\Pablo\\Desktop\\omar\\ProyectoP312022\\ProyectoP312022\\Material\\cotizacion.jfif");
            }
            enca.scaleToFit(650, 150);
            enca.setAlignment (Chunk.ALIGN_CENTER);
            

            document.open();
            document.add(header);
            document.add( Chunk.NEWLINE ); //salto de linea.
             document.add( Chunk.NEWLINE );
           
            document.add(enca);
             
             document.add(new Paragraph("               N° Factura: 0001",FontFactory.getFont(FontFactory.defaultEncoding, 13, Font.NORMAL)));
             document.add(new Paragraph("               Fecha: "+fecha,FontFactory.getFont(FontFactory.defaultEncoding, 13, Font.NORMAL)));
             document.add(new Paragraph("               Ciudad Guatemala ",FontFactory.getFont(FontFactory.defaultEncoding, 13, Font.NORMAL)));
             document.add(new Paragraph("               Correo Electronico: "+correo,FontFactory.getFont(FontFactory.defaultEncoding, 13, Font.NORMAL)));//cribir.*/
             
             document.add( Chunk.NEWLINE ); //salto de linea.
             document.add( Chunk.NEWLINE );
             
             
             
        // Este codigo genera una tabla de 3 columnas
            PdfPTable table = new PdfPTable(3);                
            PdfPCell cell = new PdfPCell(new Paragraph("Descripción",FontFactory.getFont(FontFactory.defaultEncoding, 15, Font.NORMAL)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           //table.addCell(cell);
            cell.setColspan(3);
          
            //cell.setBackgroundColor(BaseColor.DARK_GRAY);
            table.addCell(cell);
           // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            //addCell() agrega una celda a la tabla, el cambio de fila
             //ocurre automaticamente al llenar la fila
            table.addCell("             Cantidad");
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("             Producto");
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("               Precio");
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
         

            
            float total=0;
            
              for (int i=0; i<datos.length;i++){
                 for(int j=0; j<3;j++){
                     
                     
                     
                     
                 }
                 total+=Float.parseFloat(datos[i][2])* Integer.parseInt(datos[i][0]);
             }


                for (int i=0; i<datos.length;i++){
                 for(int j=0; j<3;j++){
                     if(j==2){
                     table.addCell("Q. "+datos[i][2]);
                      }else{
                     table.addCell(datos[i][j]);
                     }
                     
                 }
             }
              
         /*   table.addCell("       ");
            table.addCell("       ");
            table.addCell("       ");
             
            table.addCell("       ");
            table.addCell("       ");
            table.addCell("       ");
            
            table.addCell("       ");
            table.addCell("       ");
            table.addCell("       ");
             
            table.addCell("       ");
            table.addCell("       ");
            table.addCell("       ");*/
            //Si desea crear una celda de mas de una columna
            // Cree un objecto Cell y cambie su propiedad span
             
          
            PdfPCell celdaFinal = new PdfPCell(new Paragraph("Total",FontFactory.getFont(FontFactory.defaultEncoding, 13, Font.NORMAL)));
            celdaFinal.setHorizontalAlignment(Element.ALIGN_CENTER);
           
             
            // Indicamos cuantas columnas ocupa la celda
            celdaFinal.setColspan(2);
            table.addCell(celdaFinal);
            table.addCell("Q. "+String.valueOf(total));
            
            
            
            
            
            
             //--------------------------------

    
            // Agregamos la tabla al documento            
            document.add(table);

           
            document.close();
 
            /*System.out.println("Image  position set successfully in pdf");
        }catch (Exception e) {
            System.out.println("unable to set image position due to " + e);
        }*/
        }catch (DocumentException| FileNotFoundException e){
            System.out.println("error en df"+ e);
        } catch (IOException e) {
            System.out.println("Error en la imagen"+ e);
        }

}
       
    
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
 
/**
 * Opens a file for writing and parses a matrix to be written 
 */

public class FileWriterMatrix {

		/*
		 * Constructor
		 * 
		 * @param matrix matrix to be written in the file
		 * @filename the prefix of the final file
		 */
		FileWriterMatrix( char[][] matrix , String filename){
        try
        {
            String fileName = filename + "_out";
            FileWriter fileWriter = new FileWriter( fileName,true);
            BufferedWriter bufferedWriter = new BufferedWriter( fileWriter );
            
            for ( int i = 0 ; i < matrix.length ; i++ ){
                String matrixRow= "";
                
                for ( int j = 0 ; j < matrix[i].length ; j++ )
                {
                    matrixRow += matrix[ i ][ j ] ;
              
                }
               
                bufferedWriter.write( matrixRow );
                bufferedWriter.newLine();
                bufferedWriter.flush();
                
                
            }
     
            
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
        
    }
}
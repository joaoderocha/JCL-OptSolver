package kernel.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.Queue;

public class FileHunter {
	private static FileHunter instance;
	private File root = new File(System.getProperty("user.dir"));
	
	FileHunter(){};
	
	public static FileHunter getInstance() {
		if (instance == null) {
			instance = new FileHunter();
		}
		
		return instance;
	}
	
	private  File[] getTargetFiles(File directory, String filename){
        if(directory == null){
            return null;
        }

        File[] files = directory.listFiles(new FilenameFilter(){

            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(filename) && name.endsWith(".java");
            }

        });

        return files;
    }
	
	private  Queue<File> bfs(String filename){
	    if(root == null){
	        return null;
	    }

	    Queue<File> queue = new LinkedList<File>();
	    Queue<File> arquivosEncontrados = new LinkedList<File>();
	    queue.add(root);

	    while(!queue.isEmpty()){
	        File node = queue.remove();
	        for (File file : getTargetFiles(node, filename)) {				
	        	arquivosEncontrados.add(file);
			}
	        File[] childs = node.listFiles(new FileFilter(){


	            public boolean accept(File pathname) {
	                
	                if(pathname.isDirectory())
	                    return true;

	                return false;
	            }

	        });

	        if(childs != null){
	            for(File child: childs){
	                queue.add(child);
	            }
	        }
	    }
	    
	    return arquivosEncontrados;
	}
	
	public File[] search(String filename) {
		final Queue<File> resultado = bfs(filename);
		return (File[]) resultado.toArray(new File[resultado.size()]);
	}
	
	
}

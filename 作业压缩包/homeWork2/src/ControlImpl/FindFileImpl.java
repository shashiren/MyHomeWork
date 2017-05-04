package ControlImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Control.FindFile;

public class FindFileImpl implements FindFile {

	@Override
	public List<String> find(String dir, String FileExtension,List<String> list) {
		File file = new File(dir);
		if(list==null) list = new ArrayList<String>();
		if(!file.isDirectory())return list;
		File[] files = file.listFiles();
		for(File f: files){
			if(!f.isDirectory()){
				if(FileExtension.equalsIgnoreCase(getfileExtension(f.getName()))){
					list.add(f.getName());
				}
			}else{
				this.find(f.getAbsolutePath(),FileExtension,list);
			}
		}
		return list;
	}
	private String getfileExtension(String FileName){
		Pattern p=Pattern.compile("\\S+"+"\\."+"(\\S+)"); 
        Matcher m=p.matcher(FileName); 
        while(m.find())
        { 
          return m.group(1); 
        } 
		return null;
	}
	public static void main(String arg []){
		FindFileImpl f = new FindFileImpl();
		String s=f.getfileExtension("FlyingFox.jpg");
		System.out.print(s);
		//f.getfileExtension("m.mmm.iii");
	}
}

package Impl;

import java.util.ArrayList;
import java.util.List;

import Control.FindFile;
import ControlImpl.FindFileImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFile findfile = new FindFileImpl();
		List<String> list= findfile.find("C:\\Users\\jw\\Desktop\\bing", "jpg", new ArrayList<String>());
		if(list!=null&&list.size()>0){
			for(String fileName:list){
				System.out.println(fileName);
			}	
		}
		
	}

}

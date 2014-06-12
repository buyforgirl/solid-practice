package com.theladders.solid.lsp;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by lliao on 6/12/14.
 */
public class Test
{
    public static void main(String args[])
    {
        Environment base = new Environment();

        base.put("test1","thelad1");
        base.put("test2","thelad2");
        base.put("test3","thelad3");

        Map<String, String> keymap = new HashMap<String, String>();
        keymap.put("home","securehome");
        keymap.put("test1","securetest1");
        keymap.put("test2","securetest2");
        keymap.put("test3","securetest3");

        DynamicEnvironment dynamicEnvironment = new DynamicEnvironment(base, keymap);

        dynamicEnvironment.put("test1","test1secure");
        dynamicEnvironment.put("test2","test2secure");
        dynamicEnvironment.put("test3","test3secure");

        System.out.println(dynamicEnvironment.entrySet());

        //dynamicEnvironment.printSuper();
    }

}

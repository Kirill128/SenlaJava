package by.grsu.maptwits.twitreader;

import by.grsu.maptwits.fileworker.ITwitReader;
import by.grsu.maptwits.points.Point;
import by.grsu.maptwits.twits.Twit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TwitReader implements ITwitReader {

    @Override
    public List<Twit> readTwits(String filePath) {
        List<Twit> twits =new LinkedList<>();

        try(BufferedReader file=new BufferedReader(new FileReader(filePath))){
            String line;
            List<String> info;
            while((line=file.readLine())!=null){
                info=divideTwit(line);
                twits.add(Twit.builder()
                        .point(new Point(
                                Double.valueOf(info.get(0)),
                                Double.valueOf(info.get(1))
                                ))
                        .day(info.get(2))
                        .time(info.get(3))
                        .words(info.subList(4,info.size()))
                        .build());
            }
        }catch (IOException e){
            System.out.println("IOException"+ e.getMessage());
        }catch( NumberFormatException e){
            System.out.println("NumberFormatException"+ e.getMessage());
        }

        return twits;
    }


    public List<String> divideTwit(String twit){//TODO:BIG   hardcode was made, remake if have time
        List<String> parts=new ArrayList<>();

        char[] twitSymbols=twit.toCharArray();
        StringBuilder buf=new StringBuilder();

        int position=twit.indexOf('[');

        //------------coordinates search------------
        position++;
        while( twitSymbols[position]!=',' ){
            buf.append(twitSymbols[position++]);
        }
        parts.add(buf.toString());
        buf.delete(0,buf.length());
        position+=2;
        while( twitSymbols[position]!=']'){
            buf.append(twitSymbols[position++]);
        }
        parts.add(buf.toString());
        buf.delete(0,buf.length());

        //------------data time search------------
        for(;position<twitSymbols.length;position++) {
            if(Character.isDigit(twitSymbols[position])) {
                break;
            }
        }
        while(twitSymbols[position]!=' ' && twitSymbols[position]!='\t'){
            buf.append(twitSymbols[position++]);
        }
        parts.add(buf.toString());
        buf.delete(0,buf.length());
        position++;
        while(twitSymbols[position]!=' ' && twitSymbols[position]!='\t'){
            buf.append(twitSymbols[position++]);
        }
        parts.add(buf.toString());
        buf.delete(0,buf.length());
        //------------text search------------
        for(;position<twitSymbols.length;position++){
            if(twitSymbols[position]!=' ' && twitSymbols[position]!=',' && twitSymbols[position]!='\t'
                    && twitSymbols[position]!='.' && twitSymbols[position]!=':' && twitSymbols[position]!=';'
                    && twitSymbols[position]!='!' && twitSymbols[position]!='?' && twitSymbols[position]!='-'){
                buf.append(twitSymbols[position]);
                if(position== twitSymbols.length-1){
                    parts.add(buf.toString());
                    buf.delete(0,buf.length());}
            }else{
                if(buf.length()!=0 ){
                    parts.add(buf.toString());
                    buf.delete(0,buf.length());
                }
            }
        }
        return parts;
    }
}

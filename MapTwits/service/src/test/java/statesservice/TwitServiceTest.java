package statesservice;

import by.grsu.maptwits.sentimentreader.SentimentReader;
import by.grsu.maptwits.statesservice.TwitService;
import by.grsu.maptwits.twitreader.TwitReader;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* TwitService Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 4, 2021</pre> 
* @version 1.0 
*/ 
public class TwitServiceTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getAllTwits() 
* 
*/ 
@Test
public void testGetAllTwits() throws Exception {
    TwitService service=new TwitService(new SentimentReader(),new TwitReader());
    service.getAllTwits();
} 

/** 
* 
* Method: getSentimentReader() 
* 
*/ 
@Test
public void testGetSentimentReader() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setSentimentReader(ISentimentReader sentimentReader) 
* 
*/ 
@Test
public void testSetSentimentReader() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getTwitReader() 
* 
*/ 
@Test
public void testGetTwitReader() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setTwitReader(ITwitReader twitReader) 
* 
*/ 
@Test
public void testSetTwitReader() throws Exception { 
//TODO: Test goes here... 
} 


} 

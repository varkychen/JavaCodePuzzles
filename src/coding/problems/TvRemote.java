package coding.problems;

public class TvRemote {
/*
 * For a TV remote, determine the minimum clicks required to complete a given sequence of channels.
 * 
 * The remote has 4 options -
 *  1.) Type the whole channel number
 *  2.) Click on the left button
 *  3.) Click on the right button.
 *  4.) Click on the previous button
 *  
 * Input to the program will contain two lines
 *  1.) Start and End channels. E.g:- 0,99
 *  2.) Sequence of channels. E.g:- 22,23,25
 * 
 * Output should be the minimum clicks required to complete the sequence
 */
    public int getMinimumClicks(String channelRange, String channelSequence) {
        int noOfClicks=0;
        
        String[] startEndChannels = channelRange.split(",");
        int start = Integer.parseInt(startEndChannels[0]);
        int end = Integer.parseInt(startEndChannels[1]);
        Integer previousChannel = null;
        Integer prev2Channel = null;
        
        String[] channels = channelSequence.split(",");
        for(int i=0; i<channels.length; i++) {
            int nextChannel = Integer.parseInt(channels[i]);
            
            if(nextChannel < start || nextChannel > end)
                continue;
            
            int difference = (previousChannel == null ? channels[i].length() : Math.abs(nextChannel-previousChannel));
            int newClicks = Math.min(channels[i].length(), difference);
            
            if(prev2Channel != null && nextChannel == prev2Channel)
                newClicks = Math.min(newClicks, 1);
            
            noOfClicks += newClicks;
            
            if(previousChannel != null) prev2Channel = previousChannel;
            previousChannel = nextChannel;
        }
        return noOfClicks;
    }
}

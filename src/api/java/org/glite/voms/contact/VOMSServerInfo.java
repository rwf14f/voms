/*********************************************************************
 *
 * Authors: 
 *      Andrea Ceccanti - andrea.ceccanti@cnaf.infn.it 
 *          
 * Copyright (c) 2006-2009 INFN-CNAF on behalf of the EGEE I, II and III
 * For license conditions see LICENSE file or
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 *
 * Parts of this code may be based upon or even include verbatim pieces,
 * originally written by other people, in which case the original header
 * follows.
 *
 *********************************************************************/
package org.glite.voms.contact;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * 
 * This class represents information about a remote voms server as found
 * in vomses configuration files. See {@link VOMSESFileParser}.
 * 
 * @author Andrea Ceccanti
 * @author Vincenzo Ciaschini
 *
 */
public class VOMSServerInfo {

    String hostName;
    int port;
    String hostDn;
    String voName;
    String globusVersion;
    String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getHostDn() {
    
        return hostDn;
    }
    
    public void setHostDn( String hostDn ) {
    
        this.hostDn = hostDn;
    }
    
    public String getHostName() {
    
        return hostName;
    }
    
    public void setHostName( String hostname ) {
    
        this.hostName = hostname;
    }
    
    public int getPort() {
    
        return port;
    }
    
    public void setPort( int port ) {
    
        this.port = port;
    }
    
    public String getVoName() {
    
        return voName;
    }
    
    public void setVoName( String voName ) {
    
        this.voName = voName;
    }

    public int getGlobusVersionAsInt(){
        
        if (globusVersion == null)
            return -1;
        
        return (int)(Integer.parseInt( globusVersion ) / 10);
    }
    
    public String getGlobusVersion() {
    
        return globusVersion;
    }

    
    public void setGlobusVersion( String globusVersion ) {
    
        this.globusVersion = globusVersion;
    }
    
    public boolean equals( Object obj ) {
    
        if (this == obj)
            return true;
        
        if (!(obj instanceof VOMSServerInfo))
            return false;

        VOMSServerInfo other = (VOMSServerInfo)obj;

        if (other.getHostName() != null) {
            if (this.hostName.equals(other.getHostName())){
                return this.getPort() == other.getPort();
            }
        }
        
        return false;
        
    }
    
    public int hashCode() {
        int result = 14;
        
        result =  29 * result + hostName.hashCode();
        return 29 * result + port;
    }
    
    public static VOMSServerInfo fromStringArray(String[] tokens){
        VOMSServerInfo info = new VOMSServerInfo();
        
        info.setVoName( tokens[4] );
        info.setHostName( tokens[1] );
        info.setPort( Integer.parseInt( tokens[2] )) ;
        info.setHostDn( tokens[3] );
        info.setAlias( tokens[0] );

        // Check if the globus version is there
        if (tokens.length == 6)
            info.setGlobusVersion( tokens[5] );
        
        return info;
        
    }
    
    public String compactString(){
        
        return "[vo="+voName+",host="+hostName+",port="+port+",hostDN="+hostDn+
            ",globusVersion="+globusVersion+"]";
    }
    
    public String toString() {
    
        return ToStringBuilder.reflectionToString( this );
        
    }
}

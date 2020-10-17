// =================== DO NOT EDIT THIS FILE ====================
// Generated by Modello 1.11,
// any modifications will be overwritten.
// ==============================================================

package org.apache.maven.model;

/**
 * Configures one method for notifying users/developers when a
 * build breaks.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class Notifier
    implements java.io.Serializable, java.lang.Cloneable, org.apache.maven.model.InputLocationTracker
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The mechanism used to deliver notifications.
     */
    private String type = "mail";

    /**
     * Whether to send notifications on error.
     */
    private boolean sendOnError = true;

    /**
     * Whether to send notifications on failure.
     */
    private boolean sendOnFailure = true;

    /**
     * Whether to send notifications on success.
     */
    private boolean sendOnSuccess = true;

    /**
     * Whether to send notifications on warning.
     */
    private boolean sendOnWarning = true;

    /**
     * 
     *             
     *             <b>Deprecated</b>. Where to send the
     * notification to - eg email address.
     *             
     *           
     */
    private String address;

    /**
     * Field configuration.
     */
    private java.util.Properties configuration;

    /**
     * Field locations.
     */
    private java.util.Map<Object, InputLocation> locations;

    /**
     * Field location.
     */
    private InputLocation location;

    /**
     * Field typeLocation.
     */
    private InputLocation typeLocation;

    /**
     * Field sendOnErrorLocation.
     */
    private InputLocation sendOnErrorLocation;

    /**
     * Field sendOnFailureLocation.
     */
    private InputLocation sendOnFailureLocation;

    /**
     * Field sendOnSuccessLocation.
     */
    private InputLocation sendOnSuccessLocation;

    /**
     * Field sendOnWarningLocation.
     */
    private InputLocation sendOnWarningLocation;

    /**
     * Field addressLocation.
     */
    private InputLocation addressLocation;

    /**
     * Field configurationLocation.
     */
    private InputLocation configurationLocation;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addConfiguration.
     * 
     * @param key
     * @param value
     */
    public void addConfiguration( String key, String value )
    {
        getConfiguration().put( key, value );
    } //-- void addConfiguration( String, String )

    /**
     * Method clone.
     * 
     * @return Notifier
     */
    public Notifier clone()
    {
        try
        {
            Notifier copy = (Notifier) super.clone();

            if ( this.configuration != null )
            {
                copy.configuration = (java.util.Properties) this.configuration.clone();
            }

            if ( copy.locations != null )
            {
                copy.locations = new java.util.LinkedHashMap( copy.locations );
            }

            return copy;
        }
        catch ( java.lang.Exception ex )
        {
            throw (java.lang.RuntimeException) new java.lang.UnsupportedOperationException( getClass().getName()
                + " does not support clone()" ).initCause( ex );
        }
    } //-- Notifier clone()

    /**
     * Get <b>Deprecated</b>. Where to send the notification to -
     * eg email address.
     * 
     * @return String
     */
    public String getAddress()
    {
        return this.address;
    } //-- String getAddress()

    /**
     * Method getConfiguration.
     * 
     * @return Properties
     */
    public java.util.Properties getConfiguration()
    {
        if ( this.configuration == null )
        {
            this.configuration = new java.util.Properties();
        }

        return this.configuration;
    } //-- java.util.Properties getConfiguration()

    /**
     * 
     * 
     * @param key
     * @return InputLocation
     */
    public InputLocation getLocation( Object key )
    {
        if ( key instanceof String )
        {
            switch ( ( String ) key )
            {
                case "" :
                {
                    return this.location;
                }
                case "type" :
                {
                    return typeLocation;
                }
                case "sendOnError" :
                {
                    return sendOnErrorLocation;
                }
                case "sendOnFailure" :
                {
                    return sendOnFailureLocation;
                }
                case "sendOnSuccess" :
                {
                    return sendOnSuccessLocation;
                }
                case "sendOnWarning" :
                {
                    return sendOnWarningLocation;
                }
                case "address" :
                {
                    return addressLocation;
                }
                case "configuration" :
                {
                    return configurationLocation;
                }
                default :
                {
                    return getOtherLocation( key );
                }
                }
            }
            else
            {
                return getOtherLocation( key );
            }
    } //-- InputLocation getLocation( Object )

    /**
     * 
     * 
     * @param key
     * @param location
     */
    public void setLocation( Object key, InputLocation location )
    {
        if ( key instanceof String )
        {
            switch ( ( String ) key )
            {
                case "" :
                {
                    this.location = location;
                    return;
                }
                case "type" :
                {
                    typeLocation = location;
                    return;
                }
                case "sendOnError" :
                {
                    sendOnErrorLocation = location;
                    return;
                }
                case "sendOnFailure" :
                {
                    sendOnFailureLocation = location;
                    return;
                }
                case "sendOnSuccess" :
                {
                    sendOnSuccessLocation = location;
                    return;
                }
                case "sendOnWarning" :
                {
                    sendOnWarningLocation = location;
                    return;
                }
                case "address" :
                {
                    addressLocation = location;
                    return;
                }
                case "configuration" :
                {
                    configurationLocation = location;
                    return;
                }
                default :
                {
                    setOtherLocation( key, location );
                    return;
                }
                }
            }
            else
            {
                setOtherLocation( key, location );
            }
    } //-- void setLocation( Object, InputLocation )

    /**
     * 
     * 
     * @param key
     * @param location
     */
    public void setOtherLocation( Object key, InputLocation location )
    {
        if ( location != null )
        {
            if ( this.locations == null )
            {
                this.locations = new java.util.LinkedHashMap<Object, InputLocation>();
            }
            this.locations.put( key, location );
        }
    } //-- void setOtherLocation( Object, InputLocation )

    /**
     * 
     * 
     * @param key
     * @return InputLocation
     */
    private InputLocation getOtherLocation( Object key )
    {
        return ( locations != null ) ? locations.get( key ) : null;
    } //-- InputLocation getOtherLocation( Object )

    /**
     * Get the mechanism used to deliver notifications.
     * 
     * @return String
     */
    public String getType()
    {
        return this.type;
    } //-- String getType()

    /**
     * Get whether to send notifications on error.
     * 
     * @return boolean
     */
    public boolean isSendOnError()
    {
        return this.sendOnError;
    } //-- boolean isSendOnError()

    /**
     * Get whether to send notifications on failure.
     * 
     * @return boolean
     */
    public boolean isSendOnFailure()
    {
        return this.sendOnFailure;
    } //-- boolean isSendOnFailure()

    /**
     * Get whether to send notifications on success.
     * 
     * @return boolean
     */
    public boolean isSendOnSuccess()
    {
        return this.sendOnSuccess;
    } //-- boolean isSendOnSuccess()

    /**
     * Get whether to send notifications on warning.
     * 
     * @return boolean
     */
    public boolean isSendOnWarning()
    {
        return this.sendOnWarning;
    } //-- boolean isSendOnWarning()

    /**
     * Set <b>Deprecated</b>. Where to send the notification to -
     * eg email address.
     * 
     * @param address
     */
    public void setAddress( String address )
    {
        this.address = address;
    } //-- void setAddress( String )

    /**
     * Set extended configuration specific to this notifier goes
     * here.
     * 
     * @param configuration
     */
    public void setConfiguration( java.util.Properties configuration )
    {
        this.configuration = configuration;
    } //-- void setConfiguration( java.util.Properties )

    /**
     * Set whether to send notifications on error.
     * 
     * @param sendOnError
     */
    public void setSendOnError( boolean sendOnError )
    {
        this.sendOnError = sendOnError;
    } //-- void setSendOnError( boolean )

    /**
     * Set whether to send notifications on failure.
     * 
     * @param sendOnFailure
     */
    public void setSendOnFailure( boolean sendOnFailure )
    {
        this.sendOnFailure = sendOnFailure;
    } //-- void setSendOnFailure( boolean )

    /**
     * Set whether to send notifications on success.
     * 
     * @param sendOnSuccess
     */
    public void setSendOnSuccess( boolean sendOnSuccess )
    {
        this.sendOnSuccess = sendOnSuccess;
    } //-- void setSendOnSuccess( boolean )

    /**
     * Set whether to send notifications on warning.
     * 
     * @param sendOnWarning
     */
    public void setSendOnWarning( boolean sendOnWarning )
    {
        this.sendOnWarning = sendOnWarning;
    } //-- void setSendOnWarning( boolean )

    /**
     * Set the mechanism used to deliver notifications.
     * 
     * @param type
     */
    public void setType( String type )
    {
        this.type = type;
    } //-- void setType( String )

}

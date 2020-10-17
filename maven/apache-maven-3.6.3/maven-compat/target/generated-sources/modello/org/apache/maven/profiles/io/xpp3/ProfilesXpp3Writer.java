// =================== DO NOT EDIT THIS FILE ====================
// Generated by Modello 1.11,
// any modifications will be overwritten.
// ==============================================================

package org.apache.maven.profiles.io.xpp3;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;
import org.apache.maven.profiles.Activation;
import org.apache.maven.profiles.ActivationFile;
import org.apache.maven.profiles.ActivationOS;
import org.apache.maven.profiles.ActivationProperty;
import org.apache.maven.profiles.Profile;
import org.apache.maven.profiles.ProfilesRoot;
import org.apache.maven.profiles.Repository;
import org.apache.maven.profiles.RepositoryBase;
import org.apache.maven.profiles.RepositoryPolicy;
import org.codehaus.plexus.util.xml.pull.MXSerializer;
import org.codehaus.plexus.util.xml.pull.XmlSerializer;

/**
 * Class ProfilesXpp3Writer.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class ProfilesXpp3Writer
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field NAMESPACE.
     */
    private static final String NAMESPACE = null;

    /**
     * Field fileComment.
     */
    private String fileComment = null;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method setFileComment.
     * 
     * @param fileComment
     */
    public void setFileComment( String fileComment )
    {
        this.fileComment = fileComment;
    } //-- void setFileComment( String )

    /**
     * Method write.
     * 
     * @param writer
     * @param profilesRoot
     * @throws java.io.IOException
     */
    public void write( Writer writer, ProfilesRoot profilesRoot )
        throws java.io.IOException
    {
        XmlSerializer serializer = new MXSerializer();
        serializer.setProperty( "http://xmlpull.org/v1/doc/properties.html#serializer-indentation", "  " );
        serializer.setProperty( "http://xmlpull.org/v1/doc/properties.html#serializer-line-separator", "\n" );
        serializer.setOutput( writer );
        serializer.startDocument( profilesRoot.getModelEncoding(), null );
        writeProfilesRoot( profilesRoot, "profilesXml", serializer );
        serializer.endDocument();
    } //-- void write( Writer, ProfilesRoot )

    /**
     * Method write.
     * 
     * @param stream
     * @param profilesRoot
     * @throws java.io.IOException
     */
    public void write( OutputStream stream, ProfilesRoot profilesRoot )
        throws java.io.IOException
    {
        XmlSerializer serializer = new MXSerializer();
        serializer.setProperty( "http://xmlpull.org/v1/doc/properties.html#serializer-indentation", "  " );
        serializer.setProperty( "http://xmlpull.org/v1/doc/properties.html#serializer-line-separator", "\n" );
        serializer.setOutput( stream, profilesRoot.getModelEncoding() );
        serializer.startDocument( profilesRoot.getModelEncoding(), null );
        writeProfilesRoot( profilesRoot, "profilesXml", serializer );
        serializer.endDocument();
    } //-- void write( OutputStream, ProfilesRoot )

    /**
     * Method writeActivation.
     * 
     * @param activation
     * @param serializer
     * @param tagName
     * @throws java.io.IOException
     */
    private void writeActivation( Activation activation, String tagName, XmlSerializer serializer )
        throws java.io.IOException
    {
        serializer.startTag( NAMESPACE, tagName );
        if ( activation.isActiveByDefault() != false )
        {
            serializer.startTag( NAMESPACE, "activeByDefault" ).text( String.valueOf( activation.isActiveByDefault() ) ).endTag( NAMESPACE, "activeByDefault" );
        }
        if ( activation.getJdk() != null )
        {
            serializer.startTag( NAMESPACE, "jdk" ).text( activation.getJdk() ).endTag( NAMESPACE, "jdk" );
        }
        if ( activation.getOs() != null )
        {
            writeActivationOS( (ActivationOS) activation.getOs(), "os", serializer );
        }
        if ( activation.getProperty() != null )
        {
            writeActivationProperty( (ActivationProperty) activation.getProperty(), "property", serializer );
        }
        if ( activation.getFile() != null )
        {
            writeActivationFile( (ActivationFile) activation.getFile(), "file", serializer );
        }
        serializer.endTag( NAMESPACE, tagName );
    } //-- void writeActivation( Activation, String, XmlSerializer )

    /**
     * Method writeActivationFile.
     * 
     * @param activationFile
     * @param serializer
     * @param tagName
     * @throws java.io.IOException
     */
    private void writeActivationFile( ActivationFile activationFile, String tagName, XmlSerializer serializer )
        throws java.io.IOException
    {
        serializer.startTag( NAMESPACE, tagName );
        if ( activationFile.getMissing() != null )
        {
            serializer.startTag( NAMESPACE, "missing" ).text( activationFile.getMissing() ).endTag( NAMESPACE, "missing" );
        }
        if ( activationFile.getExists() != null )
        {
            serializer.startTag( NAMESPACE, "exists" ).text( activationFile.getExists() ).endTag( NAMESPACE, "exists" );
        }
        serializer.endTag( NAMESPACE, tagName );
    } //-- void writeActivationFile( ActivationFile, String, XmlSerializer )

    /**
     * Method writeActivationOS.
     * 
     * @param activationOS
     * @param serializer
     * @param tagName
     * @throws java.io.IOException
     */
    private void writeActivationOS( ActivationOS activationOS, String tagName, XmlSerializer serializer )
        throws java.io.IOException
    {
        serializer.startTag( NAMESPACE, tagName );
        if ( activationOS.getName() != null )
        {
            serializer.startTag( NAMESPACE, "name" ).text( activationOS.getName() ).endTag( NAMESPACE, "name" );
        }
        if ( activationOS.getFamily() != null )
        {
            serializer.startTag( NAMESPACE, "family" ).text( activationOS.getFamily() ).endTag( NAMESPACE, "family" );
        }
        if ( activationOS.getArch() != null )
        {
            serializer.startTag( NAMESPACE, "arch" ).text( activationOS.getArch() ).endTag( NAMESPACE, "arch" );
        }
        if ( activationOS.getVersion() != null )
        {
            serializer.startTag( NAMESPACE, "version" ).text( activationOS.getVersion() ).endTag( NAMESPACE, "version" );
        }
        serializer.endTag( NAMESPACE, tagName );
    } //-- void writeActivationOS( ActivationOS, String, XmlSerializer )

    /**
     * Method writeActivationProperty.
     * 
     * @param activationProperty
     * @param serializer
     * @param tagName
     * @throws java.io.IOException
     */
    private void writeActivationProperty( ActivationProperty activationProperty, String tagName, XmlSerializer serializer )
        throws java.io.IOException
    {
        serializer.startTag( NAMESPACE, tagName );
        if ( activationProperty.getName() != null )
        {
            serializer.startTag( NAMESPACE, "name" ).text( activationProperty.getName() ).endTag( NAMESPACE, "name" );
        }
        if ( activationProperty.getValue() != null )
        {
            serializer.startTag( NAMESPACE, "value" ).text( activationProperty.getValue() ).endTag( NAMESPACE, "value" );
        }
        serializer.endTag( NAMESPACE, tagName );
    } //-- void writeActivationProperty( ActivationProperty, String, XmlSerializer )

    /**
     * Method writeProfile.
     * 
     * @param profile
     * @param serializer
     * @param tagName
     * @throws java.io.IOException
     */
    private void writeProfile( Profile profile, String tagName, XmlSerializer serializer )
        throws java.io.IOException
    {
        serializer.startTag( NAMESPACE, tagName );
        if ( profile.getId() != null )
        {
            serializer.startTag( NAMESPACE, "id" ).text( profile.getId() ).endTag( NAMESPACE, "id" );
        }
        if ( profile.getActivation() != null )
        {
            writeActivation( (Activation) profile.getActivation(), "activation", serializer );
        }
        if ( ( profile.getProperties() != null ) && ( profile.getProperties().size() > 0 ) )
        {
            serializer.startTag( NAMESPACE, "properties" );
            for ( Iterator iter = profile.getProperties().keySet().iterator(); iter.hasNext(); )
            {
                String key = (String) iter.next();
                String value = (String) profile.getProperties().get( key );
                serializer.startTag( NAMESPACE, key ).text( value ).endTag( NAMESPACE, key );
            }
            serializer.endTag( NAMESPACE, "properties" );
        }
        if ( ( profile.getRepositories() != null ) && ( profile.getRepositories().size() > 0 ) )
        {
            serializer.startTag( NAMESPACE, "repositories" );
            for ( Iterator iter = profile.getRepositories().iterator(); iter.hasNext(); )
            {
                Repository o = (Repository) iter.next();
                writeRepository( o, "repository", serializer );
            }
            serializer.endTag( NAMESPACE, "repositories" );
        }
        if ( ( profile.getPluginRepositories() != null ) && ( profile.getPluginRepositories().size() > 0 ) )
        {
            serializer.startTag( NAMESPACE, "pluginRepositories" );
            for ( Iterator iter = profile.getPluginRepositories().iterator(); iter.hasNext(); )
            {
                Repository o = (Repository) iter.next();
                writeRepository( o, "pluginRepository", serializer );
            }
            serializer.endTag( NAMESPACE, "pluginRepositories" );
        }
        serializer.endTag( NAMESPACE, tagName );
    } //-- void writeProfile( Profile, String, XmlSerializer )

    /**
     * Method writeProfilesRoot.
     * 
     * @param profilesRoot
     * @param serializer
     * @param tagName
     * @throws java.io.IOException
     */
    private void writeProfilesRoot( ProfilesRoot profilesRoot, String tagName, XmlSerializer serializer )
        throws java.io.IOException
    {
        if ( this.fileComment != null )
        {
        serializer.comment(this.fileComment);
        }
        serializer.setPrefix( "", "http://maven.apache.org/PROFILES/1.0.0" );
        serializer.setPrefix( "xsi", "http://www.w3.org/2001/XMLSchema-instance" );
        serializer.startTag( NAMESPACE, tagName );
        serializer.attribute( "", "xsi:schemaLocation", "http://maven.apache.org/PROFILES/1.0.0 http://maven.apache.org/xsd/profiles-1.0.0.xsd" );
        if ( ( profilesRoot.getProfiles() != null ) && ( profilesRoot.getProfiles().size() > 0 ) )
        {
            serializer.startTag( NAMESPACE, "profiles" );
            for ( Iterator iter = profilesRoot.getProfiles().iterator(); iter.hasNext(); )
            {
                Profile o = (Profile) iter.next();
                writeProfile( o, "profile", serializer );
            }
            serializer.endTag( NAMESPACE, "profiles" );
        }
        if ( ( profilesRoot.getActiveProfiles() != null ) && ( profilesRoot.getActiveProfiles().size() > 0 ) )
        {
            serializer.startTag( NAMESPACE, "activeProfiles" );
            for ( Iterator iter = profilesRoot.getActiveProfiles().iterator(); iter.hasNext(); )
            {
                String activeProfile = (String) iter.next();
                serializer.startTag( NAMESPACE, "activeProfile" ).text( activeProfile ).endTag( NAMESPACE, "activeProfile" );
            }
            serializer.endTag( NAMESPACE, "activeProfiles" );
        }
        serializer.endTag( NAMESPACE, tagName );
    } //-- void writeProfilesRoot( ProfilesRoot, String, XmlSerializer )

    /**
     * Method writeRepository.
     * 
     * @param repository
     * @param serializer
     * @param tagName
     * @throws java.io.IOException
     */
    private void writeRepository( Repository repository, String tagName, XmlSerializer serializer )
        throws java.io.IOException
    {
        serializer.startTag( NAMESPACE, tagName );
        if ( repository.getReleases() != null )
        {
            writeRepositoryPolicy( (RepositoryPolicy) repository.getReleases(), "releases", serializer );
        }
        if ( repository.getSnapshots() != null )
        {
            writeRepositoryPolicy( (RepositoryPolicy) repository.getSnapshots(), "snapshots", serializer );
        }
        if ( repository.getId() != null )
        {
            serializer.startTag( NAMESPACE, "id" ).text( repository.getId() ).endTag( NAMESPACE, "id" );
        }
        if ( repository.getName() != null )
        {
            serializer.startTag( NAMESPACE, "name" ).text( repository.getName() ).endTag( NAMESPACE, "name" );
        }
        if ( repository.getUrl() != null )
        {
            serializer.startTag( NAMESPACE, "url" ).text( repository.getUrl() ).endTag( NAMESPACE, "url" );
        }
        if ( ( repository.getLayout() != null ) && !repository.getLayout().equals( "default" ) )
        {
            serializer.startTag( NAMESPACE, "layout" ).text( repository.getLayout() ).endTag( NAMESPACE, "layout" );
        }
        serializer.endTag( NAMESPACE, tagName );
    } //-- void writeRepository( Repository, String, XmlSerializer )

    /**
     * Method writeRepositoryBase.
     * 
     * @param repositoryBase
     * @param serializer
     * @param tagName
     * @throws java.io.IOException
     */
    private void writeRepositoryBase( RepositoryBase repositoryBase, String tagName, XmlSerializer serializer )
        throws java.io.IOException
    {
        serializer.startTag( NAMESPACE, tagName );
        if ( repositoryBase.getId() != null )
        {
            serializer.startTag( NAMESPACE, "id" ).text( repositoryBase.getId() ).endTag( NAMESPACE, "id" );
        }
        if ( repositoryBase.getName() != null )
        {
            serializer.startTag( NAMESPACE, "name" ).text( repositoryBase.getName() ).endTag( NAMESPACE, "name" );
        }
        if ( repositoryBase.getUrl() != null )
        {
            serializer.startTag( NAMESPACE, "url" ).text( repositoryBase.getUrl() ).endTag( NAMESPACE, "url" );
        }
        if ( ( repositoryBase.getLayout() != null ) && !repositoryBase.getLayout().equals( "default" ) )
        {
            serializer.startTag( NAMESPACE, "layout" ).text( repositoryBase.getLayout() ).endTag( NAMESPACE, "layout" );
        }
        serializer.endTag( NAMESPACE, tagName );
    } //-- void writeRepositoryBase( RepositoryBase, String, XmlSerializer )

    /**
     * Method writeRepositoryPolicy.
     * 
     * @param repositoryPolicy
     * @param serializer
     * @param tagName
     * @throws java.io.IOException
     */
    private void writeRepositoryPolicy( RepositoryPolicy repositoryPolicy, String tagName, XmlSerializer serializer )
        throws java.io.IOException
    {
        serializer.startTag( NAMESPACE, tagName );
        if ( repositoryPolicy.isEnabled() != true )
        {
            serializer.startTag( NAMESPACE, "enabled" ).text( String.valueOf( repositoryPolicy.isEnabled() ) ).endTag( NAMESPACE, "enabled" );
        }
        if ( repositoryPolicy.getUpdatePolicy() != null )
        {
            serializer.startTag( NAMESPACE, "updatePolicy" ).text( repositoryPolicy.getUpdatePolicy() ).endTag( NAMESPACE, "updatePolicy" );
        }
        if ( repositoryPolicy.getChecksumPolicy() != null )
        {
            serializer.startTag( NAMESPACE, "checksumPolicy" ).text( repositoryPolicy.getChecksumPolicy() ).endTag( NAMESPACE, "checksumPolicy" );
        }
        serializer.endTag( NAMESPACE, tagName );
    } //-- void writeRepositoryPolicy( RepositoryPolicy, String, XmlSerializer )

}

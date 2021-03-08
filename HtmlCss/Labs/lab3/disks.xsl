<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
    <xsl:template > 
        <html> 
            <body> 
                <table border="1" bgcolor="yellow"> 
                    <tr>
                        <td>author</td> 
                        <td>name</td>  
                        <td>cost</td>  
                        <td>size</td>  
                        <td>year</td>  
                        <td>raiting</td> 
                    </tr> 
                    <xsl:for-each select="disks/disk" order-by="name"> 
                        <tr> 
                            <td><xsl:value-of select="author"/></td> 
                            <td><xsl:value-of select="name"/></td> 
                            <td><xsl:value-of select="cost"/></td>
                            <td><xsl:value-of select="size"/></td> 
                            <td><xsl:value-of select="year"/></td> 
                            <td><xsl:value-of select="raiting"/></td> 
                        </tr> 
                    </xsl:for-each> 
                </table> 
            </body> 
        </html> 
    </xsl:template> 
</xsl:stylesheet> 
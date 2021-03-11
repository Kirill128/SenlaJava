<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
    <xsl:template match="/"> 
        <html> 
            <body> 
                <table border="1" bgcolor="yellow"> 
                    <tr>
                        <th style="text-align:left">Author</th> 
                        <th style="text-align:left">Name</th>  
                        <th style="text-align:left">Cost</th>  
                        <th style="text-align:left">size</th>  
                        <th style="text-align:left">year</th>  
                        <th style="text-align:left">raiting</th> 
                    </tr> 
                    <xsl:for-each select="disks/disk" > 
                        <xsl:sort select="name" order="descending" />
                        <tr> 
                            <td style="padding:5px">
                                <xsl:value-of select="author"/>
                                <xsl:if test=".=Nightcore">Nightcore</xsl:if>
                            </td> 
                            <td style="padding:5px"><xsl:value-of select="name"/></td> 
                            <td style="padding:5px"><xsl:value-of select="cost"/></td>
                            <td style="padding:5px"><xsl:value-of select="size"/></td> 
                            <td style="padding:5px"><xsl:value-of select="year"/></td> 
                            <td style="padding:5px"><xsl:value-of select="raiting"/></td> 
                        </tr> 
                    </xsl:for-each> 
                </table> 
            </body> 
        </html> 
    </xsl:template> 
</xsl:stylesheet> 
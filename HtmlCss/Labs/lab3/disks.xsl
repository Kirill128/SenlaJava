<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
    <xsl:template match="/"> 
        <html> 
            <body> 
                <table border="1" bgcolor="yellow"> 
                    <tr>
                        <th style="text-align:left">Num</th> 
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
                            <td>
                                <xsl:number value="position()"/>
                            </td>
                            <td style="padding:5px">
                                <xsl:value-of select="author"/>
                            </td> 
                            <td style="padding:5px"><xsl:value-of select="name"/></td> 
                            <td style="padding:5px">
                                <xsl:if test="cost > 150.0">!!!!!!</xsl:if>
                                <xsl:value-of select="cost"/>
                            </td>
                            <td style="padding:5px">
                                <xsl:value-of select="size"/>
                            </td> 
                            <td style="padding:5px"><xsl:value-of select="year"/></td> 
                            <td style="padding:5px"><xsl:value-of select="raiting"/></td> 
                        </tr> 
                    </xsl:for-each> 
                    <h2>Summary Cost: </h2>
                    <sum>
                        <xsl:value-of select="sum(disks/disk/cost)" />
                    </sum>

                    <xsl:for-each select="disks/disk">
                        <xsl:sort select="raiting" order="descending" />
                        <xsl:if test="position() = last()">
                            <h2>Min Raiting: </h2>                    
                            <xsl:value-of select="raiting"/>
                        </xsl:if>
                        <xsl:if test="position() = 1">
                            <h2>Max Raiting: </h2>                    
                            <xsl:value-of select="raiting"/>
                        </xsl:if>
                    </xsl:for-each>

                    <h2>Middle Cost: </h2>
                    <sum>
                        <xsl:value-of select="sum(disks/disk/cost) div count(//disks/disk)" />
                    </sum>
                </table> 
            </body> 
        </html> 
    </xsl:template> 
</xsl:stylesheet> 
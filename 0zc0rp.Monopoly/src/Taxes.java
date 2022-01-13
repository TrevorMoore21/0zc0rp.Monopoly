public class Taxes extends BoardSpace
	{
			private String propertyTaxes;
			private String luxuryTaxes;
			
			public Taxes(String n, int c, String o, int l, String p, String lT)
			{
				setName(n);
				setCost(c);
				setOwner(o);
				setLocation(l);
				propertyTaxes = p;
				luxuryTaxes = lT;
			}

			public String getPropertyTaxes()
				{
					return propertyTaxes;
				}

			public void setPropertyTaxes(String propertyTaxes)
				{
					this.propertyTaxes = propertyTaxes;
				}

			public String getLuxuryTaxes()
				{
					return luxuryTaxes;
				}

			public void setLuxuryTaxes(String luxuryTaxes)
				{
					this.luxuryTaxes = luxuryTaxes;
				}
			
	}
			


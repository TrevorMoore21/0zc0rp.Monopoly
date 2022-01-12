public class Taxes extends BoardSpace
	{
			private String propertyTaxes;
			private String luxuryTaxes;
			
			public Taxes(String p, String l)
			{
				propertyTaxes = p;
				luxuryTaxes = l;
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
			


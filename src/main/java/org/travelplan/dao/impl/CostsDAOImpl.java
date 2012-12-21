package org.travelplan.dao.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.CostsDAO;
import org.travelplan.entity.Costs;

import com.google.gson.Gson;

@Repository("costsDAO")
@Transactional
public class CostsDAOImpl extends CommonDAOImpl<Costs> implements CostsDAO {
	
	static class Result
    {
        private String lhs;
        private String rhs;

        public String getLhs()
        {
        	return lhs;
        }

        public String getRhs()
        {
        	return rhs;
        }

        public void setLhs(String lhs)
        {
        	this.lhs = lhs;
        }

        public void setRhs(String rhs)
        {
        	this.rhs = rhs;
        }
    }	
	
	public CostsDAOImpl() {
		super(Costs.class);
	}
	
    @SuppressWarnings("unchecked")
    public List<Costs> findByTravelRoute(Integer idTravelRoute) {
    	return (List<Costs>) getSession().createCriteria(Costs.class).
    			createAlias("travelRoute", "tr").
    			createAlias("costsList", "cl").
    			add(Restrictions.eq("tr.idTravelRoute", idTravelRoute)).
    			addOrder(Order.asc("cl.name")).
    			list();
    }	
    
    @SuppressWarnings("unchecked")
    public List<Costs> findByProfile(Integer idProfile) {
    	return (List<Costs>) getSession().createCriteria(Costs.class).
    			createAlias("travelRoute", "tr").
    			createAlias("tr.profile", "p").
    			add(Restrictions.eq("p.idProfile", idProfile)).
    			list();
    }	    
    
    private Float convertCurrency(Float value, String currencyFrom, String currencyTo) 
    		throws UnsupportedEncodingException, IOException {
    	String google = "http://www.google.com/ig/calculator?hl=en&q=";
    	String baseCurrency = currencyFrom;
    	String termCurrency = currencyTo;
    	String charset = "UTF-8";

    	URL url = new URL(google + value.toString() + baseCurrency + "=?" + termCurrency);
    	Reader reader = new InputStreamReader(url.openStream(), charset);
    	Result result = new Gson().fromJson(reader, Result.class);
    	// Get the value without the term currency.
    	Float amount = Float.valueOf(result.getRhs().split("\\s+")[0]).floatValue();
    	return amount;
    }
    
    private Float getCosts(List<Costs> listCosts, String currency) {
		Float res = 0f;
		for (Costs costs : listCosts) {
			try {
				res = res + convertCurrency(costs.getPrice(), costs.getCurrency().getValue(), currency);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}    
		return res;
    }
        
	public Float getSumTravelRoute(String currency, Integer idTravelRoute) {
		return getCosts(findByTravelRoute(idTravelRoute), currency);	
	}
	
	public Float getSum(String currency, Integer idProfile) {
		return getCosts(findByProfile(idProfile), currency);
	}
	//http://blog.caplin.com/2011/01/06/simple-currency-conversion-using-google-calculator-and-java/
	//http://motyar.blogspot.com/2011/12/googles-currency-converter-and-json-api.html
}



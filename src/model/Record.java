package model;

import java.io.Serializable;

public class Record implements Serializable {
	String DRGDefinition;
	String ProviderName;
	String ProviderState;
	String ProviderZipCode;
	long TotalDisCharges;
	long AverageCoveredCharges;
	long AverageTotalPayments;
	long AverageMedicarePayments;


	
	public Record(String DRGDefinition, String ProviderName, String ProviderState, String ProviderZipCode, long TotalDisCharges,long AverageCoveredCharges, long AverageTotalPayments, long AverageMedicarePayments){
		this.DRGDefinition = DRGDefinition;
		this.ProviderName = ProviderName;
		this.ProviderState = ProviderState;
		this.ProviderZipCode = ProviderZipCode;
		this.TotalDisCharges = TotalDisCharges ;
		this.AverageCoveredCharges = AverageCoveredCharges;
		this.AverageTotalPayments = AverageTotalPayments;
		this.AverageMedicarePayments = AverageMedicarePayments;
	}
	
	public String getDRGDefinition(){
		return DRGDefinition;
	};
	public void setDRGDefinition(String DRGDefinition){
		this.DRGDefinition = DRGDefinition;
	};
	public String getProviderName(){
		return ProviderName;
	};
	public void setProviderName(String ProviderName){
		this.ProviderName = ProviderName;
	};
	public String getProviderState(){
		return ProviderName;
	};
	public void setProviderState(String ProviderState){
		this.ProviderState = ProviderState;
	};
	public String getProviderZipCode(){
		return ProviderZipCode;
	};
	public void setProviderZipCode(String ProviderZipCode){
		this.ProviderZipCode = ProviderZipCode;
	};
	
	public long getTotalDisCharges(){
		return TotalDisCharges;
	};
	public void setTotalDisCharges(long TotalDisCharges){
		this.TotalDisCharges = TotalDisCharges ;
	};
	public long getAverageCoveredCharges(){
		return AverageCoveredCharges;
	};
	public void setAverageCoveredCharges(long  AverageCoveredCharges){
		this.AverageCoveredCharges = AverageCoveredCharges;
	};
	
	public long getAverageTotalPayments(){
		return AverageTotalPayments;
	};
	public void setAverageTotalPayments(long  AverageTotalPayments){
		this.AverageTotalPayments = AverageTotalPayments;
	};
	
	public long getAverageMedicarePayments(){
		return AverageMedicarePayments;
	};
	public void setAverageMedicarePayments(long  AverageMedicarePayments){
		this.AverageMedicarePayments = AverageMedicarePayments;
	};
}

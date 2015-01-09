package org.openxava.scm.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name="aes_part")

@Views({
	@View(members=
	"General Inforation [" +
	" name;" +
	" number;" +
	" backNumber;" +
	" category;" +
	" unitOfMeasurement;" + 
	"]" +
	"Photo [" +
	" photo;" + 
	"]" +
	"More Photo [" +
	" morePhoto;" + 
	"]" +
	"Material Information {" +
	" materialType;" +
	" specification;" +
	" cutSizeThickness;" +
	" cutSizeWidth;" +
	" cutSizePitch;" +
	" cutSizeLength;" +
	" partPerStrip;" +
	"}" + 
	"Purchasing Information {" +
	" purchaseType;" +
	" suppliers;" +
	"}" + 
	"Production Information {" +
	" standardPacking;" +
	" bufferStock;" +
	"}" +
	" BOM Information [" +
	" parent;" +
	" child;" +
	"]"
	),
	@View(name="quotationPart",
	members="name, number")
})

@Tab( properties="name, number, backNumber, category.name, unitOfMeasurement.name,purchaseType.type, photo")

public class Part extends Identifiable{	
	@Column(name = "part_name" ,length=30)
	@Required 
	private String name;
	
	@Column(name = "part_number" ,length=30)
	private String number;
	
	@Column(name = "back_number" ,length=30)
	private String backNumber;
    
	@Stereotype("PHOTO") 
	private byte [] photo;	
    public byte[] getPhoto() {
        return photo;
    }
    public void setPhoto(byte[] photo) {
        this.photo=photo;
    }
    
	@Stereotype("IMAGES_GALLERY") 
	@Column(length=90)
	private String morePhoto;	
    public String getMorePhoto() {
        return morePhoto;
    }
    public void setMorePhoto(String morePhoto) {
        this.morePhoto=morePhoto;
    }

	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList
	private PartSpecification specification;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList
	private PartCategory category;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="type")
	private MaterialType materialType;
	
	@Column(name = "cut_size_thicknesst" ,length=5)
	private float cutSizeThickness;
	
	@Column(name = "cut_size_width" ,length=5)
	private float cutSizeWidth;
	
	@Column(name = "cut_size_pitch" ,length=5)
	private float cutSizePitch;
	
	@Column(name = "cutsizelength" ,length=5)
	private float cutSizeLength;
	
	@Column(name = "part_per_strip" ,length=5)
	private int partPerStrip;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList
	private UnitOfMeasurement unitOfMeasurement;
	
	@Column(name = "standard_packing" ,length=5)
	private int standardPacking;
	
	@Column(name = "buffer_stock" ,length=5)
	private int bufferStock;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="type")
	private PurchaseType purchaseType;
	

   
   @ManyToMany (targetEntity=Organization.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	   @ListAction("ManyToMany.new")
	   @JoinTable(name="aes_part_supplier",
       joinColumns={@JoinColumn(name="part_id", referencedColumnName="oid")},
       inverseJoinColumns={@JoinColumn(name="supplier_id", referencedColumnName="oid")})
   private Collection<Organization> suppliers;
    
   public Collection<Organization> getSuppliers() {
     return suppliers;
   }
   public void setSupplier(Collection<Organization> suppliers) {
	   this.suppliers = suppliers;
   }
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="part_child",
        joinColumns={@JoinColumn(name="part_id", referencedColumnName="oid")},
        inverseJoinColumns={@JoinColumn(name="child_id", referencedColumnName="oid")})
    @ListProperties("name, number")
    private Collection<Part> parent = new ArrayList<Part>();
 
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="parent")
    @ListProperties("name, number")
    private Collection<Part> child = new ArrayList<Part>(); 
 
    public Collection<Part> getChild() {
    	return parent;
    }
    public void setChild(Collection<Part> child) {
    }
    
    public Collection<Part> getParent() {
    	return child;
    }
    public void setParent(Collection<Part> parent) {
    }

	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}	
	public String getNumber() {
	return number;
	}
	public void setNumber(String number) {
	this.number = number;
	}	
	
	public String getBackNumber() {
	return backNumber;
	}
	public void setBackNumber(String backNumber) {
	this.backNumber = backNumber;
	}
	
	public PartCategory getCategory() {
	     return category;
	}
	public void setCategory(PartCategory category) {
	     this.category = category;
	}
	
	public PartSpecification getSpecification() {
	     return specification;
	}
	public void setSpecification(PartSpecification specification) {
	     this.specification = specification;
	}
	
	public MaterialType getMaterialType() {
	     return materialType;
	}
	public void setMaterialType(MaterialType materialType) {
	     this.materialType = materialType;
	}
	
	public float getCutSizeThickness() {
	return cutSizeThickness;
	}
	public void setCutSizeThickness(float cutSizeThickness) {
	this.cutSizeThickness = cutSizeThickness;
	}
	
	public float getCutSizeWidth() {
	return cutSizeWidth;
	}
	public void setCutSizeWidth(float cutSizeWidth) {
	this.cutSizeWidth = cutSizeWidth;
	}
	
	public float getCutSizePitch() {
	return cutSizePitch;
	}
	public void setCutSizePitch(float cutSizePitch) {
	this.cutSizePitch = cutSizePitch;
	}
	
	public float getCutSizeLength() {
	return cutSizeLength;
	}
	public void setCutSizeLength(float cutSizeLength) {
	this.cutSizeLength = cutSizeLength;
	}
	
	public int getPartPerStrip() {
	return partPerStrip;
	}
	public void setPartPerStrip(int partPerStrip) {
	this.partPerStrip = partPerStrip;
	}
	
	public UnitOfMeasurement getUnitOfMeasurement() {
	     return unitOfMeasurement;
	}
	public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
	     this.unitOfMeasurement = unitOfMeasurement;
	}
	
	public int getStandardPacking() {
	return standardPacking;
	}
	public void setStandardPacking(int standardPacking) {
	this.standardPacking = standardPacking;
	}
	
	public int getBufferStock() {
	return bufferStock;
	}
	public void setBufferStock(int bufferStock) {
	this.bufferStock = bufferStock;
	}
	
	public PurchaseType getPurchaseType() {
	     return purchaseType;
	}
	public void setPurchaseType(PurchaseType purcahseType) {
	     this.purchaseType = purcahseType;
	}
	
}

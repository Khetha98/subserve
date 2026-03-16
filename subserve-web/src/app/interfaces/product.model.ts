export interface ProductModel {
 id: string;
 odooProductId:Number;
  name: string;

  price: number;

  stock: number;

  description?: string;

  category?: string;

  imageUrl?: string;
}

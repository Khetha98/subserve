import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProductModel } from '../interfaces/product.model';
import { environment } from '../../environments/environment.development';

@Injectable({ providedIn: 'root' })
export class ProductService {
  private api = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  getProducts() {
    return this.http.get<ProductModel[]>(`${this.api}/api/products`);
  }
}
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ProductService } from '../../services/product.service';
import { ProductModel } from '../../interfaces/product.model';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-detail.html',
  styleUrl: './product-detail.scss'
})
export class ProductDetail implements OnInit {

  product?: ProductModel;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService
  ) {
    console.log("ProductDetail constructor called");
  }

ngOnInit(): void {

  this.route.paramMap.subscribe(params => {

    const id = params.get('id');

    if (!id) return;

    this.productService.getProduct(id).subscribe({
      next: (data) => {
        console.log("Product received:", data);
        this.product = data;
      },
      error: (err) => console.error(err)
    });

  });

}
}
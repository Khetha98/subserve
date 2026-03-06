export interface UserModel {
  id: string
  fullName: string
  email: string
  phone?: string
  role: 'CUSTOMER' | 'FARMER' | 'ADMIN' | 'MOTORBIKEDELIVERY' | 'TELLER' | 'MANAGER' | 'SUPERVISOR'
  isVerified: boolean
  createdAt: string
  updatedAt: string
}

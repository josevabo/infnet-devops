output "app_ip" {
  value = aws_instance.app.public_ip
}
output "app_id" {
  value = aws_instance.app.id
}
output "app_ami" {
  value = aws_instance.app.ami
}
output "app_instanceType" {
  value = aws_instance.app.instance_type
}
output "app_AZ" {
  value = aws_instance.app.availability_zone
}

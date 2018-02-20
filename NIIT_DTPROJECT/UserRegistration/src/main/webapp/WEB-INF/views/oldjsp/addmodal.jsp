<div class="modal fade" id="id" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog cascading-modal" role="document">
								<!--Content-->
								<div class="modal-content">

									<!--Modal cascading tabs-->
									<div class="modal-c-tabs">

										<!-- Nav tabs -->
										<ul class="nav nav-tabs tabs-3" role="tablist">
											<li class="nav-item"><a class="nav-link active"
												data-toggle="tab" href="#id01" role="tab"><i
													class="fa fa-user mr-1"></i> supplier</a></li>
											<li class="nav-item"><a class="nav-link"
												data-toggle="tab" href="#id02" role="tab"><i
													class="fa fa-user-plus mr-1"></i> category</a></li>
											<li class="nav-item"><a class="nav-link"
												data-toggle="tab" href="#id03" role="tab"><i
													class="fa fa-user-plus mr-1"></i> product</a></li>
										</ul>

										<!-- Tab panels -->
										<div class="tab-content">
											<!--Panel 7-->
											<div class="tab-pane fade in show active" id="#id01"
												role="tabpanel">

												<!--   Body -->
												<div class="modal-body mb-1">

													<%@ include file="addsupplier.jsp"%>
													<div class="text-center mt-2">
														<button class="btn btn-info" type="submit" form="form2"
															value="saveproduct">Submit</button>
														<button type="button"
															class="btn btn-primary waves-effect ml-auto"
															data-dismiss="modal">Close</button>
													</div>
												</div>


											</div>
											<!--/.Panel 7-->
											<!--Panel 8-->
											<div class="tab-pane fade" id="id02" role="tabpanel">

												<!--Body-->
												<div class="modal-body mb-1">

													<%@include file="addcategory.jsp"%>
													<div class="text-center mt-2">
														<button class="btn btn-info" type="submit" form="form3"
															value="saveproduct">Submit</button>

														<button type="button"
															class="btn btn-primary waves-effect ml-auto"
															data-dismiss="modal">Close</button>
													</div>
												</div>

											</div>
											<div class="tab-pane fade" id="id03" role="tabpanel">
												<div class="modal-body mb-1">
													<%@include file="addproduct.jsp"%>
													<div class="text-center mt-2">
														<button class="btn btn-info" type="submit" form="form1"
															value="saveproduct">Submit</button>
														<button type="button"
															class="btn btn-primary waves-effect ml-auto"
															data-dismiss="modal">Close</button>
													</div>

												</div>

											</div>


										</div>

									</div>
								</div>
								
							</div>
